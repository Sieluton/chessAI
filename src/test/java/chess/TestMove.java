package chess;

import static org.junit.Assert.*;

import chess.move.Move;
import org.junit.Test;

public class TestMove {
    @Test
    public void testPawnMoves() {
        Board board = new Board();
        Move move = new Move();
        assertFalse("Illegal move allowed", move.playerMove("a2a5", board));
        assertFalse("Illegal move allowed", move.playerMove("a2a1", board));
        assertFalse("Illegal move allowed", move.playerMove("a2b3", board));
        assertFalse("Illegal move allowed", move.playerMove("a2b2", board));
        assertFalse("Illegal move allowed", move.playerMove("a7a6", board));
        assertFalse("Illegal move allowed", move.playerMove("a7a5", board));
        assertTrue("Double move for white not working", move.playerMove("a2a4", board));
        assertTrue("Double move for black not working", move.playerMove("c7c5", board));
        assertFalse("Illegal move allowed", move.playerMove("a4a6", board));
        assertFalse("Illegal move allowed", move.playerMove("a4a3", board));
        assertTrue("Normal move not working for white", move.playerMove("a4a5", board));
        assertTrue("En passant marker removal not working for white", board.getBoard()[5][0] == 0);
        assertTrue("Legal move not allowed", move.playerMove("b7b5", board));
        assertTrue("En passant marker removal not working for black", board.getBoard()[2][2] == 0);
        assertTrue("Legal move not allowed", move.playerMove("a5b6", board));
        assertTrue("En passant not removing black pawn", board.getBoard()[3][1] == 0);
        assertTrue("Legal move not allowed", move.playerMove("c5c4", board));
        assertTrue("Legal move not allowed", move.playerMove("b2b4", board));
        assertTrue("En passant not working for black", move.playerMove("c4b3", board));
        assertTrue("Normal take not working for white", move.playerMove("b6a7", board));
        assertFalse("Black moving white piece", move.playerMove("a7a6", board));
        assertTrue("Normal take not working for black", move.playerMove("b3c2", board));
        assertFalse("Pawn allowed to walk over enemy piece", move.playerMove("a7a8", board));
        assertTrue("Promotion not working for white", move.playerMove("a7b8", board));
        assertTrue("Promotion not happening", board.getBoard()[0][1] == -5);
        assertTrue("Normal take not working for black", move.playerMove("c2b1", board));
        assertTrue("Promotion not happening", board.getBoard()[7][1] == 5);
    }

    @Test
    public void testRookMoves() {
        int[][] gameboard = new int[8][8];
        gameboard[0][0] = 2;
        gameboard[0][7] = 2;
        gameboard[7][0] = -2;
        gameboard[7][7] = -2;
        gameboard[2][0] = 1;
        gameboard[5][7] = -1;
        gameboard[1][0] = 1;
        Board board = new Board(gameboard, true);
        Move move = new Move();
        assertFalse("White can move black rook", move.playerMove("a8b8", board));
        assertFalse("Illegal move allowed", move.playerMove("a1b2", board));
        assertFalse("Illegal move allowed", move.playerMove("a1b8", board));
        assertFalse("White rook moved on top of own piece", move.playerMove("h1h3", board));
        assertFalse("White rook moved over own piece", move.playerMove("h1h4", board));
        assertFalse("White rook moved over enemy piece", move.playerMove("a1a7", board));
        assertTrue("White rook can't take enemy piece", move.playerMove("a1a6", board));
        assertFalse("Black can move white rook", move.playerMove("a6b6", board));
        assertFalse("Illegal move allowed", move.playerMove("a8b7", board));
        assertFalse("Illegal move allowed", move.playerMove("a8b1", board));
        assertFalse("Black rook moved on top of own piece", move.playerMove("a8a6", board));
        assertFalse("Black rook moved over own piece", move.playerMove("a8a5", board));
        assertFalse("Black rook moved over enemy piece", move.playerMove("h8h2", board));
        assertTrue("Black rook can't take enemy piece", move.playerMove("h8h3", board));
        assertTrue("Legal move not allowed", move.playerMove("a6h6", board));
        assertTrue("Legal move not allowed", move.playerMove("h3a3", board));
        assertTrue("Legal move not allowed", move.playerMove("h6h3", board));
        assertTrue("Legal move not allowed", move.playerMove("a3a6", board));
        assertTrue("Legal move not allowed", move.playerMove("h3a3", board));
        assertTrue("Legal move not allowed", move.playerMove("a6h6", board));
        assertTrue("Legal move not allowed", move.playerMove("a3a6", board));
        assertTrue("Legal move not allowed", move.playerMove("h6h3", board));
    }

    @Test
    public void testKnightMoves() {
        int[][] gameboard = new int[8][8];
        gameboard[2][2] = 3;
        gameboard[5][2] = -3;
        gameboard[0][1] = 1;
        gameboard[7][3] = 1;
        gameboard[0][3] = -1;
        gameboard[7][1] = -1;
        Board board = new Board(gameboard, true);
        Move move = new Move();
        assertFalse("Illegal move allowed", move.playerMove("c3a1", board));
        assertFalse("Illegal move allowed", move.playerMove("c3d4", board));
        assertFalse("Illegal move allowed", move.playerMove("c3f4", board));
        assertFalse("Illegal move allowed", move.playerMove("c3c5", board));
        assertFalse("Illegal move allowed", move.playerMove("c3e3", board));
        assertFalse("Allowed to move over own piece", move.playerMove("c3b1", board));
        assertFalse("White allowed to move black knight", move.playerMove("c6b4", board));
        assertTrue("Not allowed to take enemy piece", move.playerMove("c3d1", board));
        assertFalse("Illegal move allowed", move.playerMove("c6a8", board));
        assertFalse("Illegal move allowed", move.playerMove("c6d7", board));
        assertFalse("Illegal move allowed", move.playerMove("c6f7", board));
        assertFalse("Illegal move allowed", move.playerMove("c6c4", board));
        assertFalse("Illegal move allowed", move.playerMove("c6e6", board));
        assertFalse("Allowed to move over own piece", move.playerMove("c6b8", board));
        assertFalse("Black allowed to move white knight", move.playerMove("c3b5", board));
        assertTrue("Not allowed to take enemy piece", move.playerMove("c6d8", board));
        assertTrue("Legal move not allowed", move.playerMove("d1e3", board));
        assertTrue("Legal move not allowed", move.playerMove("d8e6", board));
        assertTrue("Legal move not allowed", move.playerMove("e3c4", board));
        assertTrue("Legal move not allowed", move.playerMove("e6c5", board));
        assertTrue("Legal move not allowed", move.playerMove("c4e5", board));
        assertTrue("Legal move not allowed", move.playerMove("c5e4", board));
    }

    @Test
    public void testBishopMoves() {
        int[][] gameboard = new int[8][8];
        gameboard[1][1] = 4;
        gameboard[1][2] = 4;
        gameboard[6][2] = -4;
        gameboard[6][1] = -4;
        gameboard[5][6] = 1;
        gameboard[6][6] = -1;
        gameboard[1][6] = 1;
        gameboard[2][6] = -1;
        Board board = new Board(gameboard, true);
        Move move = new Move();
        assertFalse("Illegal move allowed", move.playerMove("b2a2", board));
        assertFalse("Illegal move allowed", move.playerMove("c2d2", board));
        assertFalse("Illegal move allowed", move.playerMove("b2b3", board));
        assertFalse("Illegal move allowed", move.playerMove("b2b1", board));
        assertFalse("Illegal move allowed", move.playerMove("b2c4", board));
        assertFalse("Illegal move allowed", move.playerMove("b2f7", board));
        assertFalse("White bishop allowed to move over own piece", move.playerMove("c2h7", board));

        assertFalse("White bishop allowed to move on top of own piece",
                move.playerMove("c2g6", board));

        assertFalse("White bishop allowed to move over enemy piece",
                move.playerMove("b2h8", board));

        assertFalse("White allowed to move black bishop", move.playerMove("b7a8", board));
        assertTrue("Legal move not allowed", move.playerMove("b2a1", board));
        assertFalse("Illegal move allowed", move.playerMove("b7a7", board));
        assertFalse("Illegal move allowed", move.playerMove("c7d7", board));
        assertFalse("Illegal move allowed", move.playerMove("b7b8", board));
        assertFalse("Illegal move allowed", move.playerMove("b7b6", board));
        assertFalse("Illegal move allowed", move.playerMove("b7c5", board));
        assertFalse("Illegal move allowed", move.playerMove("b7f2", board));
        assertFalse("Black bishop allowed to move over own piece", move.playerMove("c7h2", board));

        assertFalse("Black bishop allowed to move on top of own piece",
                move.playerMove("c7g3", board));

        assertFalse("Black bishop allowed to move over enemy piece",
                move.playerMove("b7h1", board));

        assertFalse("Black allowed to move white bishop", move.playerMove("a1b2", board));
        assertTrue("Legal move not allowed", move.playerMove("b7a8", board));
        assertTrue("Legal move not allowed", move.playerMove("a1g7", board));
        assertTrue("Legal move not allowed", move.playerMove("a8g2", board));
        assertTrue("Legal move not allowed", move.playerMove("g7f8", board));
        assertTrue("Legal move not allowed", move.playerMove("g2f1", board));
        assertTrue("Legal move not allowed", move.playerMove("f8h6", board));
        assertTrue("Legal move not allowed", move.playerMove("f1h3", board));
    }

    @Test //Queen moves are combination of rook and bishop moves so only limited queen testing
    public void testQueenMoves() {
        int[][] gameboard = new int[8][8];
        gameboard[1][1] = 5;
        gameboard[6][1] = -5;
        gameboard[4][4] = -1;
        gameboard[3][4] = 1;
        Board board = new Board(gameboard, true);
        Move move = new Move();
        assertTrue("Legal move not allowed", move.playerMove("b2e5", board));
        assertTrue("Legal move not allowed", move.playerMove("b7e4", board));
        assertTrue("Legal move not allowed", move.playerMove("e5b5", board));
        assertTrue("Legal move not allowed", move.playerMove("e4b4", board));
    }

    @Test
    public void testKingMoves() {
        int[][] gameboard = new int[8][8];
        gameboard[1][1] = 3;
        gameboard[0][7] = -3;
        gameboard[7][0] = -2;
        gameboard[7][7] = -2;
        gameboard[2][0] = 1;
        gameboard[5][7] = -1;
        gameboard[1][0] = 1;
        Board board = new Board(gameboard, true);
        Move move = new Move();

    }
}
