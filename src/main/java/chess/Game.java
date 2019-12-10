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
        AI ai = new AI();
        /*
        int[][] gameboard = new int[8][8];
        gameboard[7][0] = -6;
        gameboard[6][0] = -1;
        gameboard[6][1] = -1;
        gameboard[0][2] = 2;
        gameboard[0][0] = 6;
        Board board = new Board(gameboard, false);
         */

        Board board = new Board();
        boolean aivsai = false;
        Move playermove = new Move();
        Move aimove;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Want AI vs AI game type 'y' anything for normal game vs ai");
        String aionly = scanner.next();
        if (aionly.equals("y")) {
            aivsai = true;
        }
        long time = System.currentTimeMillis();
        while (true) {
            System.out.println(board + "\n");
            if (board.hasGameEnded()) {
                break;
            }
            if (board.getWhitetomove() && !aivsai) {
                String nextmove = scanner.next();
                if (nextmove.equals("tie")) {
                    break;
                }
                playermove.playerMove(nextmove, board);
            }
            else {
                aimove = ai.bestMove(board, 3);
                aimove.makeMove(board);
            }
        }
        if (board.getScore() == 0) {
            System.out.println("Game is a tie");
        }
        else if (board.getScore() == 1000) {
            System.out.println("Black has won");
        }
        else if (board.getScore() == -1000) {
            System.out.println("White has won");
        }
    }

}
