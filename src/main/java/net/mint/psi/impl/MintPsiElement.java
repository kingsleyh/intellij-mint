package net.mint.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiReference;
import net.mint.psi.MintVisitor;
import net.mint.psi.references.MintReference;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class MintPsiElement extends ASTWrapperPsiElement {
    public MintPsiElement(@NotNull ASTNode node) {
        super(node);
    }

    @NotNull
    @Contract(
            pure = true
    )
    public PsiReference[] getReferences() {
        return this.getReferencesStream().toArray(PsiReference[]::new);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MintVisitor) {
            ((MintVisitor)visitor).visitPsiElement(this);
        }
        else super.accept(visitor);
    }

    public Stream<MintReference> getReferencesStream() {
        return Arrays.stream(this.getChildren())
                .filter(c -> c instanceof MintPsiElement)
                .map(c -> getReferencesFromChild((MintPsiElement) c))
                .reduce(Stream.empty(), Stream::concat);
    }

    private Stream<MintReference> getReferencesFromChild(MintPsiElement element) {
        return element.getReferencesStream()
                .map(r -> r.referenceInAncestor(this));
    }
}
