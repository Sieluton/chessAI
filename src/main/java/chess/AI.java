package chess;

import chess.move.Move;
import chess.structures.MyQueue;

import java.util.ArrayDeque;

public class AI {
    final int maximumScore = 1000;
    int eval = 0;
    int pruned = 0;

    /**
     * Looks for the best move on given board and returns it
     * @param board Board object that stores game state
     * @param depth inf of how deep in game tree we should look
     * @return Best move given by the evaluation
     */
    public Move bestMove(Board board, int depth) {
        MyQueue movequeue = board.queue.clone();
        Board copyboard = new Board(board);
        copyboard.queue = board.queue.clone();
        Move best = (Move) movequeue.pop();
        best.makeMove(copyboard);
        int value = alphabeta(copyboard, depth, -maximumScore, maximumScore);
        while (!movequeue.isEmpty()) {
            copyboard = new Board(board);
            Move next = (Move) movequeue.pop();
            next.makeMove(copyboard);
            int nextvalue = alphabeta(copyboard, depth, -maximumScore, maximumScore);
            if (board.getWhitetomove()) {
                if (nextvalue < value) {
                    best = next;
                    value = nextvalue;
                }
            }
            else {
                if (nextvalue > value) {
                    best = next;
                    value = nextvalue;
                }
            }
        }
        System.out.println("Move evaluation " + value);
        //System.out.println("Amount of pruned moves " + pruned);
        return best;
    }

    /**
     * Alpha-beta pruning algorithm that searches the game tree and returns best possible value
     * @param board Board object that stores game state
     * @param depth How deep we should look in game tree
     * @param alpha Highest value alpha has been promised
     * @param beta Lowest value that beta has been promised
     * @return best value that has been promised
     */
    public int alphabeta(Board board, int depth, int alpha, int beta) {
        if (depth == 0 || board.hasGameEnded()) {
            return evaluate(board);
        }
        //Is it blacks turn aka max player
        if (!board.getWhitetomove()) {
            int value = -maximumScore;
            while (!board.queue.isEmpty()) {
                Board copyboard = new Board(board);
                ((Move) board.queue.pop()).makeMove(copyboard);
                value = Math.max(value, alphabeta(copyboard, depth - 1, alpha, beta));
                alpha = Math.max(alpha, value);
                if (alpha >= beta) {
                    pruned++;
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
                ((Move) board.queue.pop()).makeMove(copyboard);
                value = Math.min(value, alphabeta(copyboard, depth - 1, alpha, beta));
                alpha = Math.min(alpha, value);
                if (alpha >= beta) {
                    pruned++;
                    break;
                }
            }
            return value;
        }
    }

    /**
     * Evaluates board position and returns that evaluation
     * @param board Board object that stores game state
     * @return int evaluation of board position
     */
    public int evaluate(Board board) {
        int[][] game = board.getBoard();
        if (board.hasGameEnded()) {
            return board.getScore();
        }
        int evaluation = 0;
        for (int y = 0; y < game.length; y++) {
            for (int x = 0; x < game.length; x++) {
                evaluation += game[y][x];
            }
        }
        return evaluation;
    }
}