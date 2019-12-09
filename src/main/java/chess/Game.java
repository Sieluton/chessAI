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
        /*
        int[][] gameboard = new int[8][8];
        gameboard[7][4] = -6;
        gameboard[0][4] = 6;
        gameboard[0][0] = 2;
        gameboard[0][7] = 2;
        gameboard[7][0] = -2;
        gameboard[7][7] = -2;
        Board board = new Board(gameboard, true);
        */
        Board board = new Board();
        Move mover = new Move();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(board);
            String nextmove = scanner.next();
            mover.playerMove(nextmove, board);
        }

    }

}
