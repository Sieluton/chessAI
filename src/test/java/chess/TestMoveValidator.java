package chess;

import static org.junit.Assert.*;

import chess.move.Move;
import chess.move.MoveValidator;
import org.junit.Test;

public class TestMoveValidator {
    @Test
    public void testWhitePawnMoves() {
        int[][] gameboard = new int[8][8];
        gameboard[6][0] = -1;
        gameboard[5][0] = -1;
        gameboard[6][1] = -1;
        gameboard[5][1] = 1;
        gameboard[5][3] = 1;
        gameboard[6][2] = -1;
        gameboard[4][4] = 1;
        gameboard[6][4] = -1;
        gameboard[4][5] = -1;
        gameboard[6][5] = -1;
        MoveValidator validator = new MoveValidator();
        Board board = new Board(gameboard, true);
        assertFalse("Moved on top of own piece", validator.isValidMove(new Move(new int[]{0,6,0,5}), board));
        assertFalse("Double moved over own piece", validator.isValidMove(new Move(new int[]{0,6,0,4}), board));
        assertFalse("Double moved when not in start location", validator.isValidMove(new Move(new int[]{0,5,0,3}), board));
        assertFalse("Moved on top of enemy piece", validator.isValidMove(new Move(new int[]{1,6,1,5}), board));
        assertFalse("Double moved over enemy piece", validator.isValidMove(new Move(new int[]{1,6,1,4}), board));
        assertFalse("Double moved on top of enemy piece", validator.isValidMove(new Move(new int[]{4,6,4,4}), board));
        assertFalse("Double moved on top of own piece", validator.isValidMove(new Move(new int[]{5,6,5,4}), board));
        assertTrue("Can't take enemy piece on left", validator.isValidMove(new Move(new int[]{2,6,1,5}), board));
        assertTrue("Can't take enemy piece on right", validator.isValidMove(new Move(new int[]{2,6,3,5}), board));
        assertTrue("Can't move when valid", validator.isValidMove(new Move(new int[]{2,6,2,5}), board));
        assertTrue("Can't double move when valid", validator.isValidMove(new Move(new int[]{2,6,2,4}), board));
        assertTrue("Can't move when valid and enemy 2 steps away", validator.isValidMove(new Move(new int[]{4,6,4,5}), board));
        assertTrue("Can't move when valid and own 2 steps away", validator.isValidMove(new Move(new int[]{5,6,5,5}), board));
        gameboard = new int[8][8];
        gameboard[6][3] = -1;
        gameboard[5][2] = 1;
        gameboard[5][4] = 7;
        board.setBoard(gameboard);
        int result = 0;
        for (int i = 0; i < gameboard.length; i++){
            for (int j = 0; j < gameboard.length; j++){
                if (validator.isPawnMove(new Move(new int[]{3,6,i,j}), board)) result++;
            }
        }
        assertTrue("Looping over whole board give wrong amount of moves: " + result, result == 4);
    }


    @Test
    public void testBlackPawnMoves() {
        int[][] gameboard = new int[8][8];
        gameboard[1][0] = 1;
        gameboard[2][0] = 1;
        gameboard[1][1] = 1;
        gameboard[2][1] = -1;
        gameboard[2][3] = -1;
        gameboard[1][2] = 1;
        gameboard[3][4] = -1;
        gameboard[1][4] = 1;
        gameboard[3][5] = 1;
        gameboard[1][5] = 1;
        MoveValidator validator = new MoveValidator();
        Board board = new Board(gameboard, false);
        assertFalse("Moved on top of own piece", validator.isValidMove(new Move(new int[]{0,1,0,2}), board));
        assertFalse("Double moved over own piece", validator.isValidMove(new Move(new int[]{0,1,0,3}), board));
        assertFalse("Double moved when not in start location", validator.isValidMove(new Move(new int[]{0,2,0,4}), board));
        assertFalse("Moved on top of enemy piece", validator.isValidMove(new Move(new int[]{1,1,1,2}), board));
        assertFalse("Double moved over enemy piece", validator.isValidMove(new Move(new int[]{1,1,1,3}), board));
        assertFalse("Double moved on top of enemy piece", validator.isValidMove(new Move(new int[]{4,1,4,3}), board));
        assertFalse("Double moved on top of own piece", validator.isValidMove(new Move(new int[]{5,1,5,3}), board));
        assertTrue("Can't take enemy piece on left", validator.isValidMove(new Move(new int[]{2,1,1,2}), board));
        assertTrue("Can't take enemy piece on right", validator.isValidMove(new Move(new int[]{2,1,3,2}), board));
        assertTrue("Can't move when valid", validator.isValidMove(new Move(new int[]{2,1,2,2}), board));
        assertTrue("Can't double move when valid", validator.isValidMove(new Move(new int[]{2,1,2,3}), board));
        assertTrue("Can't move when valid and enemy 2 steps away", validator.isValidMove(new Move(new int[]{4,1,4,2}), board));
        assertTrue("Can't move when valid and own 2 steps away", validator.isValidMove(new Move(new int[]{5,1,5,2}), board));
        gameboard = new int[8][8];
        gameboard[1][3] = 1;
        gameboard[2][2] = -1;
        gameboard[2][4] = -7;
        board.setBoard(gameboard);
        int result = 0;
        for (int i = 0; i < gameboard.length; i++){
            for (int j = 0; j < gameboard.length; j++){
                if (validator.isPawnMove(new Move(new int[]{3,1,i,j}), board)) result++;
            }
        }
        assertTrue("Looping over whole board give wrong amount of moves: " + result, result == 4);
    }

}
