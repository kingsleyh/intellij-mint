package net.mint.psi;

import com.intellij.psi.tree.TokenSet;

import static net.mint.psi.MintElementTypes.MODULE;
import static net.mint.psi.MintElementTypes.STYLE;

public interface MintTokenSets {

    TokenSet IDS = TokenSet.create(STYLE, MODULE);
}
