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
LINE_COMMENT=("/*")[^\r\n]*

IDENTIFIER_CHAR=[[:letter:][:digit:]_]
HEX_CHAR=[[:digit:]A-Fa-f]
LOWER_CASE_IDENTIFIER=[:lowercase:]{IDENTIFIER_CHAR}*
CAPITALISED_IDENTIFIER=[:uppercase:]{IDENTIFIER_CHAR}*
STRING_LITERAL=\"(\\.|[^\\\"])*\"
STRING_WITH_DOUBLE_QUOTES_LITERAL=\"\"\"(\\.|[^\\\"]|\"{1,2}([^\"\\]|\\\"))*\"\"\"
STRING_WITH_SINGLE_QUOTES_LITERAL=((\" ([^\"\n])* \"?) | ("'" ([^\'\n])* \'?))
NUMBER_LITERAL=("-")?[:digit:]+(\.[:digit:]+)?
HEXADECIMAL_LITERAL=0x{HEX_CHAR}+
CHAR_LITERAL='(\\.|\\x{HEX_CHAR}+|[^\\'])'

%%
<YYINITIAL> {
  {WHITE_SPACE}           { return WHITE_SPACE; }
  {LINE_COMMENT}          { return LINE_COMMENT; }

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
  "<=>"                   { return LEFT_RIGHT_ARROW; }
  "<="                    { return LEFT_ARROW; }
  "<<="                   { return LEFT_LEFT_ARROW; }
  "<<"                    { return INSERT; }
  "<"                     { return LESS; }
  ">="                    { return GREATER_EQUAL; }
  ">>="                   { return GREATER_GREATER_EQUAL; }
  ">>"                    { return GREATER_GREATER; }
  ">"                     { return GREATER; }
  "+="                    { return PLUS_EQUAL; }
  "+"                     { return PLUS; }
  "-="                    { return MINUS_EQUAL; }
  "->"                    { return MINUS_GREATER; }
  "-"                     { return MINUS; }
  "*="                    { return TIMES_EQUAL; }
  "**="                   { return TIMES_TIMES_EQUAL; }
  "**"                    { return TIMES_TIMES; }
  "*"                     { return TIMES; }
  "/="                    { return DIVIDENTE_EQUAL; }
  "/"                     { return DIVIDENTE; }
  "%="                    { return MODULO_EQUAL; }
  "module"                { return MODULE; }
  "%}"                    { return MACRO_BLOCK_CLOSE; }
  "{%"                    { return MACRO_BLOCK_OPEN; }
  "[]="                   { return ARRAY_EQUAL; }
  "[]?"                   { return ARRAY_BOOL; }
  "[]"                    { return ARRAY; }
  "?"                     { return QUESTION; }
  ";"                     { return SEMICOLON; }
  "::"                    { return NAMESPACE; }
  ":"                     { return COLON; }
  "~"                     { return TILDE; }
  "..."                   { return DOT_DOT_DOT; }
  ".."                    { return DOT_DOT; }
  "&&="                   { return AND_AND_EQUAL; }
  "&&"                    { return AND_AND; }
  "&="                    { return AND_EQUAL; }
  "&"                     { return AND; }
  "||="                   { return OR_OR_EQUAL; }
  "||"                    { return OR_OR; }
  "|="                    { return OR_EQUAL; }
  "^="                    { return CAROT_EQUAL; }
  "^"                     { return CAROT; }
  "@["                    { return AT_BRACKET; }
  "@"                     { return AT; }
  "$~"                    { return DOLLAR_TILDE; }
  "$?"                    { return DOLLAR_QUESTION; }
  "case"                  { return CASE; }
  "def"                   { return DEF; }
  "do"                    { return DO; }
  "else"                  { return ELSE; }
  "end"                   { return END; }
  "if"                    { return IF; }
  "nil"                   { return NIL; }
  "of"                    { return OF; }
  "require"               { return REQUIRE; }
  "when"                  { return WHEN; }
  "yield"                 { return YIELD; }
  "until"                 { return UNTIL; }
  "elsif"                 { return ELSIF; }
  "true"                  { return TRUE; }
  "false"                 { return FALSE; }
  "raise"                 { return RAISE; }
  "include"               { return INCLUDE; }
  "extend"                { return EXTEND; }
  "return"                { return RETURN; }
  "begin"                 { return BEGIN; }
  "lib"                   { return LIB; }
  "fun"                   { return FUN; }
  "struct"                { return STRUCT; }
  "union"                 { return UNION; }
  "enum"                  { return ENUM; }
  "macro"                 { return MACRO; }
  "out"                   { return OUT; }
  "as"                    { return AS; }
  "as?"                   { return AS_QUESTION; }
  "typeof"                { return TYPEOF; }
  "for"                   { return FOR; }
  "select"                { return SELECT; }
  "then"                  { return THEN; }
  "rescue"                { return RESCUE; }
  "ensure"                { return ENSURE; }
  "is_a?"                 { return IS_A_QUESTION; }
  "alias"                 { return ALIAS; }
  "sizeof"                { return SIZEOF; }
  "nil?"                  { return NIL_QUESTION; }
  "in"                    { return IN; }
  "with"                  { return WITH; }
  "self"                  { return SELF; }
  "super"                 { return SUPER; }
  "private"               { return PRIVATE; }
  "asm"                   { return ASM; }
  "protected"             { return PROTECTED; }
  "uninitialized"         { return UNINITIALIZED; }
  "instance_sizeof"       { return INSTANCE_SIZEOF; }
  "abstract"              { return ABSTRACT; }
  "pointerof"             { return POINTEROF; }
  "break"                 { return BREAK; }
  "initialize"            { return INITIALIZE; }
  "new"                   { return NEW; }
  "loop"                  { return LOOP; }
  "prepend"               { return PREPEND; }
  "fail"                  { return FAIL; }
  "getter"                { return GETTER; }
  "setter"                { return SETTER; }
  "property"              { return PROPERTY; }
  "catch"                 { return CATCH; }
  "throw"                 { return THROW; }
  "abort"                 { return ABORT; }
  "at_exit"               { return AT_EXIT; }
  "autoload"              { return AUTOLOAD; }
  "binding"               { return BINDING; }
  "callcc"                { return CALLCC; }
  "caller"                { return CALLER; }
  "caller_locations"      { return CALLER_LOCATIONS; }
  "chomp"                 { return CHOMP; }
  "chop"                  { return CHOP; }
  "eval"                  { return EVAL; }
  "exec"                  { return EXEC; }
  "exit"                  { return EXIT; }
  "exit!"                 { return EXIT_BANG; }
  "fork"                  { return FORK; }
  "format"                { return FORMAT; }
  "gets"                  { return GETS; }
  "global_variables"      { return GLOBAL_VARIABLES; }
  "gsub"                  { return GSUB; }
  "iterator"              { return ITERATOR; }
  "lambda"                { return LAMBDA; }
  "load"                  { return LOAD; }
  "local_variables"       { return LOCAL_VARIABLES; }
  "open"                  { return OPEN; }
  "p"                     { return P; }
  "print"                 { return PRINT; }
  "printf"                { return PRINTF; }
  "proc"                  { return PROC; }
  "putc"                  { return PUTC; }
  "puts"                  { return PUTS; }
  "rand"                  { return RAND; }
  "readline"              { return READLINE; }
  "readlines"             { return READLINES; }
  "set_trace_func"        { return SET_TRACE_FUNC; }
  "sleep"                 { return SLEEP; }
  "spawn"                 { return SPAWN; }
  "sprintf"               { return SPRINTF; }
  "srand"                 { return SRAND; }
  "sub"                   { return SUB; }
  "syscall"               { return SYSCALL; }
  "system"                { return SYSTEM; }
  "test"                  { return TEST; }
  "trace_var"             { return TRACE_VAR; }
  "trap"                  { return TRAP; }
  "untrace_var"           { return UNTRACE_VAR; }
  "warn"                  { return WARN; }
  "component"             { return COMPONENT; }
  "store"                 { return STORE; }
  "state"                 { return STATE; }
  "property"              { return PROPERTY; }
  "next"                  { return NEXT; }
  "where"                 { return WHERE; }
  "\\>"                   { return HTML_CLOSE_END; }
  "</"                    { return HTML_CLOSE; }

  {LOWER_CASE_IDENTIFIER} { return IDENT; }
    {CAPITALISED_IDENTIFIER} {
        return IDENT;
    }
    {STRING_WITH_DOUBLE_QUOTES_LITERAL} {
        return STRING_LITERAL;
    }
     {STRING_WITH_SINGLE_QUOTES_LITERAL} {
            return STRING_LITERAL;
        }
    {STRING_LITERAL} {
        return STRING_LITERAL;
    }
    {CHAR_LITERAL} {
        return CHAR_LITERAL;
    }
    {NUMBER_LITERAL} {
        return NUMBER_LITERAL;
    }
    {HEXADECIMAL_LITERAL} {
        return NUMBER_LITERAL;
    }

}

[^] { return BAD_CHARACTER; }
