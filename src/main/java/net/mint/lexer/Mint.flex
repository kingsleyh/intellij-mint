package net.mint.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static net.mint.psi.MintElementTypes.*;

%%

%{
  public _MintLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _MintLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

WHITE_SPACE=\s+

IDENTIFIER_CHAR=[[:letter:][:digit:]_]
LOWER_CASE_IDENTIFIER=[:lowercase:]{IDENTIFIER_CHAR}*
CAPITALISED_IDENTIFIER=[:uppercase:]{IDENTIFIER_CHAR}*
STRING_LITERAL=\"(\\.|[^\\\"])*\"
STRING_WITH_DOUBLE_QUOTES_LITERAL=\"\"\"(\\.|[^\\\"]|\"{1,2}([^\"\\]|\\\"))*\"\"\"
NUMBER_LITERAL=("-")?[:digit:]+(\.[:digit:]+)?

BLOCK_COMMENT_START = "/*"
BLOCK_COMMENT_END = "*/"

BACKTICKS=\`(\\.|[^\\\`]|\n)*\`


%x BLOCK_COMMENT_CONTENT


%%

<BLOCK_COMMENT_CONTENT> {
	{BLOCK_COMMENT_START}	{
		return MLCOMMENT;
	}

	\/? {BLOCK_COMMENT_END}	{
		yybegin(YYINITIAL);
		return MLCOMMENT;
	}
	\n|\/|\*	{return MLCOMMENT;}
	[^/*\n]+	{return MLCOMMENT;}
}

<YYINITIAL> {BLOCK_COMMENT_START} {
		yybegin(BLOCK_COMMENT_CONTENT);
		return MLCOMMENT;
	}


<YYINITIAL> {
  {WHITE_SPACE}           { return WHITE_SPACE; }
  {BACKTICKS}             { return STRING_LITERAL; }
  "`"                     { return BACKTICK; }
  "{"                     { return LEFT_BRACE; }
  "}"                     { return RIGHT_BRACE; }
  "("                     { return LEFT_PAREN; }
  ")"                     { return RIGHT_PAREN; }
  "["                     { return LEFT_BRACKET; }
  "]"                     { return RIGHT_BRACKET; }
  "|"                     { return PIPE; }
  "."                     { return DOT; }
  ","                     { return COMMA; }
  "="                     { return EQUAL; }
  "=="                    { return EQUAL_EQUAL; }
  "\\\\"                  { return BACKSLASH; }
  "=>"                    { return RIGHT_ARROW; }
  "!="                    { return NOT_EQUAL; }
  "!"                     { return NOT; }
  "<="                    { return LEFT_ARROW; }
  "<"                     { return LESS; }
  ">="                    { return GREATER_EQUAL; }
  ">"                     { return GREATER; }
  "+="                    { return PLUS_EQUAL; }
  "+"                     { return PLUS; }
  "->"                    { return MINUS_GREATER; }
  "|>"                    { return FUNCTION_PIPE; }
  "-"                     { return MINUS; }
  "*"                     { return TIMES; }
  "/"                     { return DIVIDENTE; }
  "%"                     { return MODULO; }
  "[]"                    { return ARRAY; }
  "::"                    { return NAMESPACE; }
  ":"                     { return COLON; }
  "&&"                    { return AND_AND; }
  "&"                     { return AND; }
  "||"                    { return OR_OR; }
  "#"                     { return HASH; }
  "$"                     { return DOLLAR; }
  "?"                     { return QUESTION; }
  ";"                     { return SEMI; }
  "case"                  { return CASE; }
  "sequence"              { return SEQUENCE; }
  "parallel"              { return PARALLEL; }
  "try"                   { return TRY; }
  "else"                  { return ELSE; }
  "if"                    { return IF; }
  "true"                  { return TRUE; }
  "false"                 { return FALSE; }
  "as"                    { return AS; }
  "decode"                { return DECODE; }
  "encode"                { return ENCODE; }
  "using"                 { return USING; }
  "property"              { return PROPERTY; }
  "record"                { return RECORD; }
  "catch"                 { return CATCH; }
  "component"             { return COMPONENT; }
  "module"                { return MODULE; }
  "store"                 { return STORE; }
  "state"                 { return STATE; }
  "next"                  { return NEXT; }
  "where"                 { return WHERE; }
  "when"                  { return WHEN; }
  "with"                  { return WITH; }
  "finally"               { return FINALLY; }
  "fun"                   { return FUN; }
  "get"                   { return GET; }
  "use"                   { return USE; }
  "enum"                  { return ENUM; }
  "void"                  { return VOID; }
  "provider"              { return PROVIDER; }
  "routes"                { return ROUTES; }
  "connect"               { return CONNECT; }
  "exposing"              { return EXPOSING; }
  "style"                 { return STYLE; }
  "suite"                 { return SUITE; }
  "test"                  { return TEST; }

  {LOWER_CASE_IDENTIFIER} { return LOWER_IDENT; }
    {CAPITALISED_IDENTIFIER} {
        return CAPITALISED_IDENT;
    }
    {STRING_WITH_DOUBLE_QUOTES_LITERAL} {
        return STRING_LITERAL;
    }
    {STRING_LITERAL} {
        return STRING_LITERAL;
    }
    {NUMBER_LITERAL} {
        return NUMBER_LITERAL;
    }

}

[^] { return BAD_CHARACTER; }
