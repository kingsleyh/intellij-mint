#!/bin/sh

GEN_DIR=src/main/gen

rm -rf build
rm -rf $GEN_DIR
mkdir -p $GEN_DIR

#GRAMMAR_KIT="grammar-kit.jar"
#LIB="distros/ideaIC-2018.1/lib"
#BNF_FILE=src/main/java/net/mint/parser/Mint.bnf
#java -cp "$GRAMMAR_KIT:$LIB/*:src" org.intellij.grammar.Main $GEN_DIR $BNF_FILE

JFLEX="jflex-1.7.0-SNAPSHOT.jar"
FLEX_FILE=src/main/java/net/mint/lexer/Mint.flex
SKEL_FILE=idea-flex.skeleton
java -cp "$JFLEX" -jar $JFLEX -d $GEN_DIR --skel $SKEL_FILE $FLEX_FILE
