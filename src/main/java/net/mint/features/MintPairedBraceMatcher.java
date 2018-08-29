package net.mint.features;

import com.intellij.formatting.WhiteSpace;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static net.mint.psi.MintElementTypes.*;

public class MintPairedBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = new BracePair[] {
            new BracePair(LEFT_BRACE, RIGHT_BRACE, true),
            new BracePair(LEFT_BRACKET, RIGHT_BRACKET, true),
            new BracePair(LEFT_PAREN, RIGHT_PAREN, false)
    };

    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return contextType == null
                || contextType == WHITE_SPACE;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
