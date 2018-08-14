# Mint plugin for the IntelliJ Platform


[![Build Status](https://travis-ci.org/kingsleyh/intellij-mint.svg?branch=master)](https://travis-ci.org/kingsleyh/intellij-mint)
[![License](https://img.shields.io/badge/License-BSD%203--Clause-blue.svg)](https://opensource.org/licenses/BSD-3-Clause)


## Status

This plugin is still in the **early stages of development** so only has a handful of features. But over time things will stabilize and more features will be added. Currently 
only the lexer and some very basic syntax highlighting are done - see screenshot below.
 
 
## Usage

Coming soon...

## Roadmap

The following features will evolve over the next few months:

* full lexer - with tests
* full grammar parser - with tests
* default syntax highlighting color scheme - based on Atom light theme
* darcula syntax highlighting color scheme - based on Atom dark theme
* working commenter
* Go to definition
* jump to implementation
* refactor - rename

Features for later on:

* mint intellij project type
* compiler support and run configurations
* code formatting
* code auto completion

## Releases

coming soon

## FAQ

coming soon 

## Compatible Jetbrains Products

| Release version | IntelliJ version |
|-----------------|------------------|
| 1.1-SNAPSHOT    | 2017.3           |


## Contributing
 
coming soon 

### Dev

1. clone the repo
2. ./gradlew idea
3. ./gradlew build
4. open in intellij

### Testing notes

* to regenerate the parser and lexer run: ./regenerate.sh 

