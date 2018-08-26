package net.mint.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import net.mint.lexer.MintHighlightLexer;
import net.mint.psi.MintTokenSets;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static net.mint.psi.MintElementTypes.*;


public class MintSyntaxHighlighter extends SyntaxHighlighterBase {
    private static final Map<IElementType, TextAttributesKey> keys = new HashMap<IElementType, TextAttributesKey>();

    public static final TextAttributesKey MINT_COMMENT = createKey("MINT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

//    public static final TextAttributesKey BLOCK_COMMENT = createKey("MINT_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

    public static final TextAttributesKey KEYWORD = createKey("MINT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey STRING = createKey("MINT_STRING", DefaultLanguageHighlighterColors.STRING);

//    private static final TextAttributes STRING_GAP_ATTR;

//    static {
//        STRING_GAP_ATTR = STRING.getDefaultAttributes().clone();
//        STRING_GAP_ATTR.setForegroundColor(JBColor.GRAY);
//    }

//    public static final TextAttributesKey STRING_GAP = createTextAttributesKey("MINT_STRING_GAP", STRING_GAP_ATTR);

    public static final TextAttributesKey NUMBER = createKey("MINT_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey MINT_BRACKETS = createKey("MINT_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey MINT_BRACES = createKey("MINT_BRACES", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey MINT_PARENTHESIS = createKey("MINT_PARENTHESIS", DefaultLanguageHighlighterColors.BRACKETS);

    public static final TextAttributesKey OPERATOR = createKey("MINT_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    public static final TextAttributesKey VARIABLE = createKey("MINT_VARIABLE", CodeInsightColors.INSTANCE_FIELD_ATTRIBUTES);

//    public static final TextAttributesKey MODULE_NAME = createKey("MINT_MODULE_NAME", CodeInsightColors.ANNOTATION_NAME_ATTRIBUTES);

    public static final TextAttributesKey FUNCTION_DECLARATION = createKey("MINT_FUNCTION_DECLARATION", CodeInsightColors.METHOD_CALL_ATTRIBUTES);

    public static final TextAttributesKey MINT_EQ = createKey("MINT_EQ", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    public static final TextAttributesKey MINT_COMMA = createKey("MINT_COMMA", DefaultLanguageHighlighterColors.COMMA);

    public static final TextAttributesKey MINT_DOT = createKey("MINT_DOT", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    public static final TextAttributesKey MINT_DCOLON = createKey("MINT_DCOLON", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    public static final TextAttributesKey MINT_ARROW = createKey("MINT_ARROW", DefaultLanguageHighlighterColors.OPERATION_SIGN);

//    public static final TextAttributesKey MINT_UNDERSCORE = createKey("MINT_UNDERSCORE", DefaultLanguageHighlighterColors.OPERATION_SIGN);



    // annotation highlighting
//
//    // 'log' in 'import Control.Monad.Eff.Console (log)'
//    public static final TextAttributesKey IMPORT_REF = createKey("MINT_IMPORT_REF", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
//
//    // 'String' in 'foo :: String -> String'
//    public static final TextAttributesKey TYPE_NAME = createKey("MINT_TYPE_NAME", CodeInsightColors.ANNOTATION_NAME_ATTRIBUTES);
//
//    // 'foo' in 'foo :: String -> String'
//    public static final TextAttributesKey TYPE_ANNOTATION_NAME = createKey("MINT_TYPE_ANNOTATION_NAME", CodeInsightColors.ANNOTATION_NAME_ATTRIBUTES);
//
//    // 'a' in 'foo:: forall a. a -> a -> String'
//    public static final TextAttributesKey TYPE_VARIABLE = createKey("MINT_TYPE_VARIABLE", CodeInsightColors.ANNOTATION_NAME_ATTRIBUTES);

    static {
        fillMap(keys, TokenSet.create(MLCOMMENT), MINT_COMMENT);
        fillMap(keys, MintTokenSets.Keywords, KEYWORD);
        fillMap(keys, TokenSet.create(NUMBER_LITERAL), NUMBER);
        fillMap(keys, TokenSet.create(STRING_LITERAL), STRING);
        fillMap(keys, TokenSet.create(LEFT_PAREN, RIGHT_PAREN), MINT_PARENTHESIS);
        fillMap(keys, TokenSet.create(LEFT_BRACKET, RIGHT_BRACKET), MINT_BRACKETS);
        fillMap(keys, TokenSet.create(LEFT_BRACE, RIGHT_BRACE), MINT_BRACES);
        fillMap(keys, MintTokenSets.Operators, OPERATOR);
        fillMap(keys, TokenSet.create(LOWER_IDENT), VARIABLE);
        fillMap(keys, TokenSet.create(CAPITALISED_IDENT), FUNCTION_DECLARATION);
        keys.put(EQUAL, MINT_EQ);
        keys.put(COMMA, MINT_COMMA);
        keys.put(DOT, MINT_DOT);
        keys.put(NAMESPACE, MINT_DCOLON);
        keys.put(LEFT_ARROW, MINT_ARROW);
        keys.put(RIGHT_ARROW, MINT_ARROW);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new MintHighlightLexer();
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(keys.get(tokenType));
    }

    private static TextAttributesKey createKey(String externalName, TextAttributesKey fallbackAttrs) {
        return createTextAttributesKey(externalName, fallbackAttrs);
    }
}

