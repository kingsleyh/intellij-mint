package net.mint.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import net.mint.icons.MintIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static net.mint.highlighting.MintSyntaxHighlighter.*;

public class MintColorSettingsPage implements ColorSettingsPage {

    @NonNls
    private static final Map<String, TextAttributesKey> TAG_HIGHLIGHTING_MAP = new HashMap<String, TextAttributesKey>();

//    static {
//        TAG_HIGHLIGHTING_MAP.put("import_ref", IMPORT_REF); // blue
//        TAG_HIGHLIGHTING_MAP.put("type_variable", TYPE_VARIABLE); // red
//        TAG_HIGHLIGHTING_MAP.put("type_name", TYPE_NAME); // yellow
//        TAG_HIGHLIGHTING_MAP.put("type_annotation_name", TYPE_ANNOTATION_NAME); // blue
//    }

    private static final AttributesDescriptor[] ATTRIBS = {
            new AttributesDescriptor("Keyword", KEYWORD),
            new AttributesDescriptor("Number", NUMBER),
            new AttributesDescriptor("String", STRING),
            new AttributesDescriptor("Operator", OPERATOR),
            new AttributesDescriptor("Type", TYPE_NAME),
//            new AttributesDescriptor("Type Variable", TYPE_VARIABLE),
//            new AttributesDescriptor("Type Annotation//Name", TYPE_ANNOTATION_NAME),
            new AttributesDescriptor("Punctuation//Arrows", MINT_ARROW),
            new AttributesDescriptor("Punctuation//Parentheses", MINT_PARENTHESIS),
            new AttributesDescriptor("Punctuation//Braces", MINT_BRACES),
            new AttributesDescriptor("Punctuation//Brackets", MINT_BRACKETS),
            new AttributesDescriptor("Punctuation//Comma", MINT_COMMA),
            new AttributesDescriptor("Punctuation//Dot", MINT_DOT),
            new AttributesDescriptor("Punctuation//Equals", MINT_EQ),
//            new AttributesDescriptor("Import Reference", IMPORT_REF),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return MintIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new MintSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {

        return "store Store {\n" +
                "  state counter : Number = 0\n" +
                "\n" +
                "  fun increment : Void {\n" +
                "    next { counter = counter + 1 }\n" +
                "  }\n" +
                "\n" +
                "  fun decrement : Void {\n" +
                "    next { counter = counter - 1 }\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "component Main {\n" +
                "  connect Store exposing { increment, decrement, counter }\n" +
                "\n" +
                "  property disabled : Bool = false\n" +
                "\n" +
                "  style base {\n" +
                "    background: {background};\n" +
                "    border-radius: 5px;\n" +
                "    transition: 320ms;\n" +
                "    display: flex;\n" +
                "    padding: 20px;\n" +
                "    margin: 20px;\n" +
                "  }\n" +
                "\n" +
                "  style counter {\n" +
                "    font-family: sans;\n" +
                "    font-size: 20px;\n" +
                "    padding: 0 20px;\n" +
                "  }\n" +
                "\n" +
                "  get background : String {\n" +
                "    if (counter >= 10) {\n" +
                "      \"lightgreen\"\n" +
                "    } else {\n" +
                "      if (counter < 0) {\n" +
                "        \"orangered\"\n" +
                "      } else {\n" +
                "        \"#F2F2F2\"\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "\n" +
                "  fun render : Html {\n" +
                "    <div::base>\n" +
                "      <button\n" +
                "        onClick={(event : Html.Event) : Void => { decrement() }}\n" +
                "        disabled={disabled}>\n" +
                "\n" +
                "        <{ \"Decrement\" }>\n" +
                "\n" +
                "      </button>\n" +
                "\n" +
                "      <span::counter>\n" +
                "        <{ Number.toString(counter) }>\n" +
                "      </span>\n" +
                "\n" +
                "      <button\n" +
                "        onClick={(event : Html.Event) : Void => { increment() }}\n" +
                "        disabled={disabled}>\n" +
                "\n" +
                "        <{ \"Increment\" }>\n" +
                "\n" +
                "      </button>\n" +
                "    </div>\n" +
                "  }\n" +
                "}\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return TAG_HIGHLIGHTING_MAP;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return ATTRIBS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Mint";
    }
}

