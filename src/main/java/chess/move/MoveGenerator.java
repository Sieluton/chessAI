package chess.move;

import chess.Board;
import chess.move.MoveValidator;

import java.util.ArrayDeque;
import java.util.Queue;

public class MoveGenerator {
    public MoveValidator validator = new MoveValidator();
    public ArrayDeque<Move> queue = new ArrayDeque<>();

    public ArrayDeque<Move> generateMoves(Board board){
        int[][] game = board.getBoard();
        int[] move = new int[4];
        for (int y = 0; y < game.length; y++) {
            for (int x = 0; x < game.length; x++) {
                move[0] = x;
                move[1] = y;
                if (game[y][x] == -1 && board.getWhitetomove()) {
                    generatePawnMoves(board, move);
                }
                else if (game[y][x] == 1 && !board.getWhitetomove()) {
                    generatePawnMoves(board, move);
                }
                else if (game[y][x] == -2 && board.getWhitetomove()) {
                    generateRookMoves(board, move);
                }
                else if (game[y][x] == 2 && !board.getWhitetomove()) {
                    generateRookMoves(board, move);
                }
                else if (game[y][x] == -3 && board.getWhitetomove()) {
                    generateKnightMoves(board, move);
                }
                else if (game[y][x] == 3 && !board.getWhitetomove()) {
                    generateKnightMoves(board, move);
                }
                else if (game[y][x] == -4 && board.getWhitetomove()) {
                    generateBishopMoves(board, move);
                }
                else if (game[y][x] == 4 && !board.getWhitetomove()) {
                    generateBishopMoves(board, move);
                }
                else if (game[y][x] == -5 && board.getWhitetomove()) {
                    generateQueenMoves(board, move);
                }
                else if (game[y][x] == 5 && !board.getWhitetomove()) {
                    generateQueenMoves(board, move);
                }
                else if (game[y][x] == -6 && board.getWhitetomove()) {
                    generateKingMoves(board, move);
                }
                else if (game[y][x] == 6 && !board.getWhitetomove()) {
                    generateKingMoves(board, move);
                }
            }
        }
        return this.queue;
    }

    public void generatePawnMoves(Board board, int[] move) {
        int[][] game = board.getBoard();

        if (board.getWhitetomove()) {
            if (move[1] == 6) {
                move[2] = move[0];
                move[3] = move[1] - 2;
                if (validator.isPawnMove(new Move(move), board)) {
                    queue.add(new Move(move));
                }
            }

            move[2] = move[0];
            move[3] = move[1] - 1;
            if (validator.isPawnMove(new Move(move), board)) {
                queue.add(new Move(move));
            }

            move[2] = move[0] - 1;
            move[3] = move[1] - 1;
            moveOutOfBounds(move);
            if (validator.isPawnMove(new Move(move), board)) {
                queue.add(new Move(move));
            }

            move[2] = move[0] + 1;
            move[3] = move[1] - 1;
            moveOutOfBounds(move);
            if (validator.isPawnMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }

        if (!board.getWhitetomove()) {
            if (move[1] == 1) {
                move[2] = move[0];
                move[3] = move[1] + 2;
                if (validator.isPawnMove(new Move(move), board)) {
                    queue.add(new Move(move));
                }
            }

            move[2] = move[0];
            move[3] = move[1] + 1;
            if (validator.isPawnMove(new Move(move), board)) {
                queue.add(new Move(move));
            }

            move[2] = move[0] - 1;
            move[3] = move[1] + 1;
            if (!moveOutOfBounds(move)){
                if (validator.isPawnMove(new Move(move), board)) {
                    queue.add(new Move(move));
                }
            }

            move[2] = move[0] + 1;
            move[3] = move[1] + 1;
            if (!moveOutOfBounds(move)){
                if (validator.isPawnMove(new Move(move), board)) {
                    queue.add(new Move(move));
                }
            }
        }
    }

    public void generateKnightMoves(Board board, int[] move) {
        move[2] = move[0] + 1;
        move[3] = move[1] + 2;
        if (!moveOutOfBounds(move)){
            if (validator.isKnightMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[2] = move[0] + 1;
        move[3] = move[1] - 2;
        if (!moveOutOfBounds(move)){
            if (validator.isKnightMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[2] = move[0] - 1;
        move[3] = move[1] + 2;
        if (!moveOutOfBounds(move)){
            if (validator.isKnightMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[2] = move[0] - 1;
        move[3] = move[1] - 2;
        if (!moveOutOfBounds(move)){
            if (validator.isKnightMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[2] = move[0] + 2;
        move[3] = move[1] + 1;
        if (!moveOutOfBounds(move)){
            if (validator.isKnightMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[2] = move[0] + 2;
        move[3] = move[1] - 1;
        if (!moveOutOfBounds(move)){
            if (validator.isKnightMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[2] = move[0] - 2;
        move[3] = move[1] + 1;
        if (!moveOutOfBounds(move)){
            if (validator.isKnightMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[2] = move[0] - 2;
        move[3] = move[1] - 1;
        if (!moveOutOfBounds(move)){
            if (validator.isKnightMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
    }

    public void generateRookMoves(Board board, int[] move) {
        move[3] = move[1];
        for (int i = move[0] + 1; i < board.getBoard().length; i++) {
            move[2] = i;
            if (!validator.isRookMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        for (int i = move[0] - 1; i >= 0; i--) {
            move[2] = i;
            if (!validator.isRookMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }
        move[2] = move[0];
        for (int i = move[1] + 1; i < board.getBoard().length; i++) {
            move[3] = i;
            if (!validator.isRookMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        for (int i = move[1] - 1; i >= 0; i--) {
            move[3] = i;
            if (!validator.isRookMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }
    }

    public void generateBishopMoves(Board board, int[] move) {
        int length = board.getBoard().length;
        for (int i = 1; i < length; i++) {
            if ((move[0] + i >= length) ||
                    (move[1] + i >= length)) {
                break;
            }
            move[2] = move[0] + i;
            move[3] = move[1] + i;
            if (!validator.isBishopMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        for (int i = 1; i < length; i++) {
            if ((move[0] + i >= length) ||
                    (move[1] - i < 0)) {
                break;
            }
            move[2] = move[0] + i;
            move[3] = move[1] - i;
            if (!validator.isBishopMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        for (int i = 1; i < length; i++) {
            if ((move[0] - i < 0) ||
                    (move[1] + i >= length)) {
                break;
            }
            move[2] = move[0] - i;
            move[3] = move[1] + i;
            if (!validator.isBishopMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        for (int i = 1; i < length; i++) {
            if ((move[0] - i < 0) ||
                    (move[1] - i < 0)) {
                break;
            }
            move[2] = move[0] - i;
            move[3] = move[1] - i;
            if (!validator.isBishopMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }
    }

    public void generateQueenMoves(Board board, int[] move) {
        //Rook moves
        move[3] = move[1];
        for (int i = move[0] + 1; i < board.getBoard().length; i++) {
            move[2] = i;
            if (!validator.isQueenMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        for (int i = move[0] - 1; i >= 0; i--) {
            move[2] = i;
            if (!validator.isQueenMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }
        move[2] = move[0];
        for (int i = move[1] + 1; i < board.getBoard().length; i++) {
            move[3] = i;
            if (!validator.isQueenMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        for (int i = move[1] - 1; i >= 0; i--) {
            move[3] = i;
            if (!validator.isQueenMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        //Bishop moves
        int length = board.getBoard().length;
        for (int i = 1; i < length; i++) {
            if ((move[0] + i >= length) ||
                    (move[1] + i >= length)) {
                break;
            }
            move[2] = move[0] + i;
            move[3] = move[1] + i;
            if (!validator.isQueenMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        for (int i = 1; i < length; i++) {
            if ((move[0] + i >= length) ||
                    (move[1] - i < 0)) {
                break;
            }
            move[2] = move[0] + i;
            move[3] = move[1] - i;
            if (!validator.isQueenMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        for (int i = 1; i < length; i++) {
            if ((move[0] - i < 0) ||
                    (move[1] + i >= length)) {
                break;
            }
            move[2] = move[0] - i;
            move[3] = move[1] + i;
            if (!validator.isQueenMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }

        for (int i = 1; i < length; i++) {
            if ((move[0] - i < 0) ||
                    (move[1] - i < 0)) {
                break;
            }
            move[2] = move[0] - i;
            move[3] = move[1] - i;
            if (!validator.isQueenMove(new Move(move), board)) {
                break;
            }
            queue.add(new Move(move));
        }
    }

    public void generateKingMoves(Board board, int[] move) {
        if (board.getWhitetomove() && !board.isWhitekingmoved()) {
            move[2] = 0;
            move[3] = 7;
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
            move[2] = 7;
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }

        if (!board.getWhitetomove() && !board.isBlackkingmoved()) {
            move[2] = 0;
            move[3] = 0;
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
            move[2] = 7;
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[2] = move[0];
        move[3] = move[1] + 1;
        if (!moveOutOfBounds(move)) {
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[3] = move[1] - 1;
        if (!moveOutOfBounds(move)) {
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }

        move[2] = move[0] - 1;
        move[3] = move[1];
        if (!moveOutOfBounds(move)) {
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[3] = move[1] + 1;
        if (!moveOutOfBounds(move)) {
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[3] = move[1] - 1;
        if (!moveOutOfBounds(move)) {
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }

        move[2] = move[0] + 1;
        move[3] = move[1];
        if (!moveOutOfBounds(move)) {
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[3] = move[1] + 1;
        if (!moveOutOfBounds(move)) {
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
        move[3] = move[1] - 1;
        if (!moveOutOfBounds(move)) {
            if (validator.isKingMove(new Move(move), board)) {
                queue.add(new Move(move));
            }
        }
    }

    public boolean moveOutOfBounds(int[] move) {
        if (move[2] < 0 || move[2] > 7) {
            return true;
        }
        if (move[3] < 0 || move[3] > 7) {
            return true;
        }
        return false;
    }
}
