package chess;

import chess.move.Move;

import java.util.Scanner;

public class Game {

    /**
     * Game runs here
     * @param args
     */
    public static void main(String[] args) {
        // Use this to set specific board

        int[][] gameboard = new int[8][8];
        gameboard[1][0] = -1;
        gameboard[0][1] = 2;
        gameboard[0][0] = 6;
        Board board = new Board(gameboard, true);

        //Board board = new Board();
        Board copyboard = new Board(board);
        Move mover = new Move();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.generateMoves();
            System.out.println(board);
            System.out.println(board.queue.size());
            System.out.println(copyboard.queue.size());
            String nextmove = scanner.next();
            mover.playerMove(nextmove, board);

        }

    }

}
