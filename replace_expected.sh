#!/bin/sh

rm -rf src/test/resources/gold/lexer/expected/*
cp out/test/resources/gold/lexer/expected/* src/test/resources/gold/lexer/expected

#rm -rf src/test/resources/gold/parser/current/*.psi
#cp out/test/resources/gold/parser/current/*.psi src/test/resources/gold/parser/current
