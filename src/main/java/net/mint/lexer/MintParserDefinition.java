package net.mint.lexer;

import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.IStubFileElementType;
import com.intellij.psi.tree.TokenSet;
import net.mint.MintParser;
import net.mint.file.MintFile;
import net.mint.file.MintFileStubType;
import net.mint.parser._MintLexer;
import net.mint.psi.MintElementTypes;
import org.jetbrains.annotations.NotNull;




import com.intellij.lang.ASTNode;
        import com.intellij.lang.ParserDefinition;
        import com.intellij.lang.PsiParser;
        import com.intellij.lexer.FlexAdapter;
        import com.intellij.lexer.Lexer;
        import com.intellij.openapi.project.Project;
        import com.intellij.psi.FileViewProvider;
        import com.intellij.psi.PsiElement;
        import com.intellij.psi.PsiFile;
        import com.intellij.psi.TokenType;
        import com.intellij.psi.tree.IFileElementType;
        import com.intellij.psi.tree.IStubFileElementType;
        import com.intellij.psi.tree.TokenSet;

        import org.jetbrains.annotations.NotNull;

public class MintParserDefinition implements ParserDefinition {

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(MintElementTypes.LINE_COMMENT);
    public static final IStubFileElementType FILE_ELEMENT_TYPE = MintFileStubType.INSTANCE;

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new FlexAdapter(new _MintLexer(null));
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new MintParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE_ELEMENT_TYPE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new MintFile(viewProvider);
    }

    public ParserDefinition.SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return ParserDefinition.SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return MintElementTypes.Factory.createElement(node);
    }

}

