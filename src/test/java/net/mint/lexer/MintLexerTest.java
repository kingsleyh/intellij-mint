package net.mint.lexer;

public class MintLexerTest extends MintLexerTestBase {

    public MintLexerTest() {
        super("lexer");
    }

    // keywords
    public void testkeyword_component() { doTest(true, true); }
    public void testkeyword_case() { doTest(true, true); }
    public void testkeyword_do() { doTest(true, true); }
    public void testkeyword_try() { doTest(true, true); }
    public void testkeyword_if_else() { doTest(true, true); }
    public void testkeyword_true_false() { doTest(true, true); }
    public void testkeyword_decode_as() { doTest(true, true); }
    public void testkeyword_using() { doTest(true, true); }
    public void testkeyword_property() { doTest(true, true); }
    public void testkeyword_record() { doTest(true, true); }
    public void testkeyword_catch() { doTest(true, true); }
    public void testkeyword_module() { doTest(true, true); }
    public void testkeyword_store() { doTest(true, true); }
    public void testkeyword_state() { doTest(true, true); }
    public void testkeyword_next() { doTest(true, true); }
    public void testkeyword_where() { doTest(true, true); }
    public void testkeyword_fun() { doTest(true, true); }
    public void testkeyword_get() { doTest(true, true); }
    public void testkeyword_enum() { doTest(true, true); }
    public void testkeyword_routes() { doTest(true, true); }

    // Other symbols
    public void testother_symbols() { doTest(true, true);}

    // Html
    public void testother_html() { doTest(true, true);}

    // Css
    public void testother_css() { doTest(true, true);}

    // Js
    public void testother_js() { doTest(true, true);}

}

