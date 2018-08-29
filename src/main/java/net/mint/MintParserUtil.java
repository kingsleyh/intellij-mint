package net.mint;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.tree.IElementType;
import net.mint.psi.MintTokenSets;

import java.util.Objects;

import static net.mint.psi.MintElementTypes.*;

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

    public static boolean nonStrictIdNested(PsiBuilder builder_, int level_) {
        final PsiBuilder.Marker marker_ = builder_.mark();
        IElementType tokenType = builder_.getTokenType();

        System.out.print(tokenType);
//        if (MintTokenSets.Keywords.contains(tokenType)) {
//
//            builder_.advanceLexer();
//
//            marker_.done(FUNCTION_CALL_IDENTIFIER);
//            return true;
//        } else {
            marker_.rollbackTo();
            return false;
//        }
//
//        if (MintTokenSets.Keywords.contains(tokenType)) {
//            marker_.done(tokenType);
//            return nonStrictID(builder_, level_);
//        } else {
//            marker_.rollbackTo();
//            return false;
//        }

//        final boolean result_ = consumeToken(builder_, LOWER_IDENT);
//        final PsiBuilder.Marker marker_ = builder_.mark();
//        if(result_){
//
//            marker_.done(IDENTIFIER);
//            return true;
//        } else {
//            marker_.rollbackTo();
//            return false;
//        }
//        marker_.rollbackTo();
//       return false;
    }

//    public static boolean nonStrictID(PsiBuilder builder_, int level_) {
//        final PsiBuilder.Marker marker_ = builder_.mark();
//
//        final boolean result_ = consumeToken(builder_, LOWER_IDENT);
//        if (result_) {
//            marker_.done(IDENTIFIER);
//            return true;
//        }
//        else if (MintTokenSets.IDS.contains(builder_.getTokenType())) {
//            builder_.advanceLexer();
//            marker_.done(IDENTIFIER);
//            return true;
//        }
//        marker_.rollbackTo();
//        return false;
//    }

    public static boolean nonStrictID(PsiBuilder builder_, int level_) {
        final PsiBuilder.Marker marker_ = builder_.mark();

        final boolean result_ = consumeToken(builder_, LOWER_IDENT);
        if (result_) {
            marker_.done(IDENTIFIER);
            return true;
        }
        else if (MintTokenSets.IDS.contains(builder_.getTokenType())) {
            builder_.advanceLexer();

            marker_.done(IDENTIFIER);
            return true;
        }
        marker_.rollbackTo();
        return false;
    }
}
