package net.mint.lexer;

import com.intellij.lexer.FlexAdapter;
import net.mint.parser._MintLexer;

public class MintHighlightLexer extends FlexAdapter {
    public MintHighlightLexer() {
        super(new _MintLexer(null));
    }
}

