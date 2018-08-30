package net.mint.psi.references;


import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface MintReference extends PsiReference {
    MintReference referenceInAncestor(PsiElement ancestor);

    PsiElement getReferencingElement();

    MintReferenceTarget getTarget();
}