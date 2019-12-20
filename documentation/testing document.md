# Unit testing
Almost all of the testing is done with Unit tests.
Test coverage is good and most cases are tested.

## Piece rules

MoveValidator is used to test these since it gives information is move legal for specific piece.

## Piece moves

Most legal moves have been tested.
Tests cover some illegal moves to check that they are not allowed.

## Move generation

Tests are made by giving specific board and checking how many moves it generated and then comparing it to the real value of legal moves that have been counted by hand.

## Queue data structure

Tested that empty queue returns true when asked if empty. Also adding and taking from queue is tested.

# Manual testing

Most of the testing is done with unit tests.

Some of the boards functionality is tested in other parts of unit tests and biggest part in board that is not tested is toString which should be noticed if giving wrong output.