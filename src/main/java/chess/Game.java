package chess;

import chess.move.Move;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Board board = new Board();
        Move mover = new Move();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(board);
            mover.playerMove(scanner.next(), board);
        }

    }

}
