package chess;

import chess.move.Move;

import java.util.Scanner;

public class Game {

    /**
     * Game runs here
     * @param args
     */
    public static void main(String[] args) {
        AI ai = new AI();
        Board board = new Board();
        boolean aivsai = false;
        Move playermove = new Move();
        Move aimove;
        int depth;
        long length = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Want AI vs AI game type 'y' anything for normal game vs AI");
        String aionly = scanner.next();
        if (aionly.equals("y")) {
            System.out.println("How many seconds should AI vs AI game take at most?");
            length = scanner.nextLong() * 1000;
            aivsai = true;
        }
        System.out.println("How deep should the AI look? (over 3 is slow)");
        depth = scanner.nextInt();

        long time = System.currentTimeMillis();
        while (true) {
            System.out.println(board + "\n");
            long time2 = System.currentTimeMillis();
            if (board.hasGameEnded() || ((time2 - time) > length && aivsai)) {
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
                aimove = ai.bestMove(board, depth);
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
