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

        gameboard[7][7] = -2;
        Board board = new Board(gameboard, true);

        //Board board = new Board();
        Board copyboard = new Board(board);
        Move mover = new Move();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(board);
            while (!board.queue.isEmpty()) {
                System.out.println("" + board.queue.size());
                board.queue.pop();
            }
            String nextmove = scanner.next();
            mover.playerMove(nextmove, board);
        }

    }

}
