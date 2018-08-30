package net.mint.psi.impl;

import com.intellij.lang.ASTNode;
import net.mint.psi.MintNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class MintNamedElementImpl extends MintPsiElement implements MintNamedElement {
    public MintNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
