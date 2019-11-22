package chess;

import chess.move.Move;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        /* Use this to set specific board
        int[][] gameboard = new int[8][8];
        gameboard[2][2] = 3;
        gameboard[5][2] = -3;
        gameboard[0][1] = 1;
        gameboard[7][3] = 1;
        gameboard[0][3] = -1;
        gameboard[7][1] = -1;
        Board board = new Board(gameboard, true);
        */
        Board board = new Board();
        Move mover = new Move();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(board);
            String nextmove = scanner.next();
            mover.playerMove(nextmove, board);
        }

    }

}
