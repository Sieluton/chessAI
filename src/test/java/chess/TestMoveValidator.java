package chess;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestMoveValidator {
    @Test
    public void testWhitePawnMoves() {
        int[][] gameboard = new int[8][8];
        // Test move when blocked by friendly piece and can you do double move when not in starting position
        gameboard[6][0] = -1;
        gameboard[5][0] = -1;
        // Test move when blocked by enemy piece
        gameboard[6][1] = -1;
        // Test eating both sides and moving when free
        gameboard[5][1] = 1;
        gameboard[5][3] = 1;
        gameboard[6][2] = -1;
        // Test move when blocked by one square away by enemy piece
        gameboard[4][4] = 1;
        gameboard[6][4] = -1;
        // Test move when blocked by one square away by friendly piece
        gameboard[4][5] = 1;
        gameboard[6][5] = -1;
        MoveValidator validator = new MoveValidator();
        Board board = new Board(gameboard, true);
        assertFalse(validator.isMoveValid(new int[]{0,6,0,5}, board));
        assertFalse(validator.isMoveValid(new int[]{0,6,0,4}, board));
        assertFalse(validator.isMoveValid(new int[]{0,5,0,3}, board));
        assertFalse(validator.isMoveValid(new int[]{1,6,1,5}, board));
        assertFalse(validator.isMoveValid(new int[]{1,6,1,4}, board));
        assertTrue(validator.isMoveValid(new int[]{2,6,1,5}, board));
        assertTrue(validator.isMoveValid(new int[]{2,6,3,5}, board));
        assertTrue(validator.isMoveValid(new int[]{2,6,2,5}, board));
        assertTrue(validator.isMoveValid(new int[]{2,6,2,4}, board));
        assertTrue(validator.isMoveValid(new int[]{4,6,4,5}, board));
        assertFalse(validator.isMoveValid(new int[]{4,6,4,4}, board));
        assertTrue(validator.isMoveValid(new int[]{5,6,5,5}, board));
        assertFalse(validator.isMoveValid(new int[]{5,6,5,4}, board));
    }


}
