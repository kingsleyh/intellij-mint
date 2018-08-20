package net.mint;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import net.mint.psi.MintTokenSets;

import static net.mint.psi.MintElementTypes.LOWER_ID;
import static net.mint.psi.MintElementTypes.LOWER_IDENT;

public class MintParserUtil extends GeneratedParserUtilBase {

    public static boolean nonStrictID(PsiBuilder builder_, int level_) {
        final PsiBuilder.Marker marker_ = builder_.mark();
        final boolean result_ = consumeToken(builder_, LOWER_IDENT);
        if (result_) {
            marker_.done(LOWER_ID);
            return true;
        }
        else if (MintTokenSets.IDS.contains(builder_.getTokenType())) {
            builder_.advanceLexer();
            marker_.done(LOWER_ID);
            return true;
        }
        marker_.rollbackTo();
        return false;
    }
}
