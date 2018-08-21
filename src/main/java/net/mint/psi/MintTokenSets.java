package net.mint.psi;

import com.intellij.psi.tree.TokenSet;

import static net.mint.psi.MintElementTypes.*;

public interface MintTokenSets {

    TokenSet IDS = TokenSet.create(STYLE, MODULE, COMPONENT, STORE, STATE, PROPERTY, NEXT, RECORD);

    TokenSet Keywords = TokenSet.create(
            CASE,
            DO,
            TRY,
            ELSE,
            IF,
            TRUE,
            FALSE,
            AS,
            DECODE,
            ENCODE,
            USING,
            PROPERTY,
            RECORD,
            CATCH,
            COMPONENT,
            MODULE,
            STORE,
            STATE,
            NEXT,
            WHERE,
            WHEN,
            WITH,
            FINALLY,
            FUN,
            GET,
            USE,
            ENUM,
            VOID,
            PROVIDER,
            ROUTES,
            CONNECT,
            EXPOSING,
            STYLE
    );

    TokenSet Operators = TokenSet.create(
            BACKTICK,
            PIPE,
            EQUAL_EQUAL,
            BACKSLASH,
            RIGHT_ARROW,
            NOT_EQUAL,
            NOT,
            LEFT_ARROW,
            LESS,
            GREATER_EQUAL,
            GREATER,
            PLUS_EQUAL,
            PLUS,
            MINUS_GREATER,
            FUNCTION_PIPE,
            MINUS,
            TIMES,
            DIVIDENTE,
            MODULO,
            ARRAY,
            COLON,
            AND_AND,
            AND,
            OR_OR,
            HASH,
            DOLLAR,
            QUESTION,
            SEMI
    );


}
