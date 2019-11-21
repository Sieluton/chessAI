package chess;

import static org.junit.Assert.*;

import chess.move.Move;
import org.junit.Test;

public class TestMove {
    @Test
    public void TestPawnMoves(){
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
}
