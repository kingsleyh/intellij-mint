package net.mint.psi.references;


import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.IncorrectOperationException;
import net.mint.psi.MintNamedElement;
import net.mint.psi.utils.Function3;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

abstract class MintReferenceBase<T extends PsiElement> extends PsiReferenceBase<PsiElement> implements MintReference {
    final T referencingElement;

    MintReferenceBase(T element) {
        this(element, element, new TextRange(0, element.getTextLength()));
    }

    MintReferenceBase(PsiElement element, T referencingElement, TextRange rangeInElement) {
        super(element, rangeInElement);
        this.referencingElement = referencingElement;
    }

    public MintReference referenceInAncestor(PsiElement ancestor) {
        int diff = this.myElement.getTextOffset() - ancestor.getTextOffset();
        return constructor().apply(ancestor, this.referencingElement, this.getRangeInElement().shiftRight(diff));
    }

    public PsiElement getReferencingElement() {
        return this.referencingElement;
    }

    @Override
    public MintReferenceTarget getTarget() {
        return MintReferenceTarget.SYMBOL;
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        if (this.referencingElement instanceof MintNamedElement) {
            return ((MintNamedElement)this.referencingElement).setName(newElementName);
        }
        return this.referencingElement;
    }

    protected abstract Function3<PsiElement, T, TextRange, MintReference> constructor();

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }

    boolean theSameName(@NotNull PsiElement element) {
        return element.getText().equals(this.referencingElement.getText());
    }

    boolean theSameNameOrEmpty(Optional<T> optionalElem) {
        return optionalElem.map(this::theSameName)
                .orElse(true);
    }

//    @Nullable
//    <U extends PsiElement> PsiElement resolveUsingModuleIndex(String moduleName, Function<ElmFile, Optional<U>> resolver) {
//        return ModuleIndexHelper.resolveUsingModuleIndex(
//                moduleName,
//                this.myElement.getProject(),
//                resolver
//        );
//    }
}
