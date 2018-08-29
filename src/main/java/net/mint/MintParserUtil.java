package net.mint;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.tree.IElementType;
import net.mint.psi.MintTokenSets;

import static net.mint.psi.MintElementTypes.IDENTIFIER;
import static net.mint.psi.MintElementTypes.LOWER_IDENT;

public class MintParserUtil extends GeneratedParserUtilBase {

    public static boolean nonStrictId(PsiBuilder builder_, int level_) {
        final PsiBuilder.Marker marker_ = builder_.mark();
        IElementType tokenType = builder_.getTokenType();

        consumeToken(builder_, tokenType);

        if (MintTokenSets.Keywords.contains(tokenType)) {
            marker_.done(IDENTIFIER);
            return true;
        } else {
            if (tokenType == null) {
                marker_.rollbackTo();
                return false;
            } else {
                if (tokenType == LOWER_IDENT) {
                    marker_.done(IDENTIFIER);
                    return true;
                } else {
                    marker_.done(tokenType);
                    return true;
                }
            }
        }
    }
}
