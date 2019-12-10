package chess;

import chess.move.Move;

public class AI {
    final int maximumScore = 1000;

    public int alphabeta(Board board, int depth, int alpha, int beta) {
        if (depth == 0 || board.hasGameEnded()) {
            return evaluate(board);
        }
        //Is it blacks turn aka max player
        if (!board.getWhitetomove()) {
            int value = -maximumScore;
            while (!board.queue.isEmpty()) {
                Board copyboard = new Board(board);
                board.queue.pop().makeMove(copyboard);
                value = Math.max(value, alphabeta(copyboard, depth - 1, alpha, beta));
                alpha = Math.max(alpha, value);
                if (alpha >= beta) {
                    break;
                }
            }
            return value;
        }
        //It is whites turn aka min player
        else {
            int value = maximumScore;
            while (!board.queue.isEmpty()) {
                Board copyboard = new Board(board);
                board.queue.pop().makeMove(copyboard);
                value = Math.min(value, alphabeta(copyboard, depth - 1, alpha, beta));
                alpha = Math.min(alpha, value);
                if (alpha >= beta) {
                    break;
                }
            }
            return value;
        }
    }

    public int evaluate(Board board) {
        return 0;
    }
}
