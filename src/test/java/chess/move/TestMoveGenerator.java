package chess.move;

        import static org.junit.Assert.*;

        import chess.Board;
        import chess.move.Move;
        import org.junit.Test;

        import java.util.Deque;

public class TestMoveGenerator {

    @Test
    public void testPawnMoveGeneration(){
        int[][] gameboard;
        Board board;
        Deque<Move> queue;

        //Whites moves
        gameboard = new int[8][8];
        gameboard[6][4] = -1;
        gameboard[5][3] = 1;
        gameboard[5][5] = 1;
        board = new Board(gameboard, true);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 4);

        //Blacks moves
        gameboard = new int[8][8];
        gameboard[1][4] = 1;
        gameboard[2][3] = -1;
        gameboard[2][5] = -1;
        board = new Board(gameboard, false);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 4);
    }

    @Test
    public void testRookMoveGeneration(){
        int[][] gameboard;
        Board board;
        Deque<Move> queue;

        //Whites moves
        gameboard = new int[8][8];
        gameboard[3][4] = -2;
        board = new Board(gameboard, true);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 14);

        //Blacks moves
        gameboard = new int[8][8];
        gameboard[3][4] = 2;
        board = new Board(gameboard, false);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 14);
    }

    @Test
    public void testKnightMoveGeneration(){
        int[][] gameboard;
        Board board;
        Deque<Move> queue;

        //Whites moves
        gameboard = new int[8][8];
        gameboard[3][4] = -3;
        board = new Board(gameboard, true);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 8);

        //Blacks moves
        gameboard = new int[8][8];
        gameboard[3][4] = 3;
        board = new Board(gameboard, false);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 8);
    }

    @Test
    public void testBishopMoveGeneration(){
        int[][] gameboard;
        Board board;
        Deque<Move> queue;

        //Whites moves
        gameboard = new int[8][8];
        gameboard[3][4] = -4;
        board = new Board(gameboard, true);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 13);

        //Blacks moves
        gameboard = new int[8][8];
        gameboard[3][4] = 4;
        board = new Board(gameboard, false);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 13);
    }

    @Test
    public void testQueenMoveGeneration(){
        int[][] gameboard;
        Board board;
        Deque<Move> queue;

        //Whites moves
        gameboard = new int[8][8];
        gameboard[3][4] = -5;
        board = new Board(gameboard, true);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 27);

        //Blacks moves
        gameboard = new int[8][8];
        gameboard[3][4] = 5;
        board = new Board(gameboard, false);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 27);
    }

    @Test
    public void testKingMoveGeneration(){
        int[][] gameboard;
        Board board;
        Deque<Move> queue;

        //Whites moves
        gameboard = new int[8][8];
        gameboard[3][4] = -6;
        board = new Board(gameboard, true);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 8);

        //Blacks moves
        gameboard = new int[8][8];
        gameboard[3][4] = 6;
        board = new Board(gameboard, false);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 8);

        //Whites castling
        gameboard = new int[8][8];
        gameboard[7][4] = -6;
        gameboard[7][0] = -2;
        gameboard[7][7] = -2;
        board = new Board(gameboard, true);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 26);

        //Blacks castling
        gameboard = new int[8][8];
        gameboard[0][4] = 6;
        gameboard[0][0] = 2;
        gameboard[0][7] = 2;
        board = new Board(gameboard, false);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.size() == 26);
    }
    @Test
    public void testNoMoves() {
        int[][] gameboard = new int[8][8];
        Deque<Move> queue;
        Board board = new Board(gameboard, true);
        queue = new MoveGenerator().generateMoves(board);
        assertTrue("" + queue.size(),queue.isEmpty());
    }
}
