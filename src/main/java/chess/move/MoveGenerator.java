package chess.move;

import chess.Board;
import chess.move.MoveValidator;

import java.util.ArrayDeque;

public class MoveGenerator {
    public MoveValidator validator = new MoveValidator();
    public ArrayDeque<Move> queue = new ArrayDeque<>();

    public ArrayDeque<Move> generateMoves(Board board){
        int[][] game = board.getBoard();
        int[] move = new int[4];
        for (int y = 0; y < game.length; y++) {
            for (int x = 0; x < game.length; x++) {
                if (game[y][x] == -1 && board.getWhitetomove()) {
                    generatePawnMoves(board, x, y);
                }
                else if (game[y][x] == 1 && !board.getWhitetomove()) {
                    generatePawnMoves(board, x, y);
                }
                else if (game[y][x] == -2 && board.getWhitetomove()) {
                    generateRookMoves(board, x, y);
                }
                else if (game[y][x] == 2 && !board.getWhitetomove()) {
                    generateRookMoves(board, x, y);
                }
                else if (game[y][x] == -3 && board.getWhitetomove()) {
                    generateKnightMoves(board, x, y);
                }
                else if (game[y][x] == 3 && !board.getWhitetomove()) {
                    generateKnightMoves(board, x, y);
                }
                else if (game[y][x] == -4 && board.getWhitetomove()) {
                    generateBishopMoves(board, x, y);
                }
                else if (game[y][x] == 4 && !board.getWhitetomove()) {
                    generateBishopMoves(board, x, y);
                }
                else if (game[y][x] == -5 && board.getWhitetomove()) {
                    generateQueenMoves(board, x, y);
                }
                else if (game[y][x] == 5 && !board.getWhitetomove()) {
                    generateQueenMoves(board, x, y);
                }
                else if (game[y][x] == -6 && board.getWhitetomove()) {
                    generateKingMoves(board, x, y);
                }
                else if (game[y][x] == 6 && !board.getWhitetomove()) {
                    generateKingMoves(board, x, y);
                }
            }
        }
        return this.queue;
    }

    public void generatePawnMoves(Board board, int x, int y) {
        int[][] game = board.getBoard();
        int x2 = 0;
        int y2 = 0;

        if (board.getWhitetomove()) {
            if (y == 6) {
                x2 = x;
                y2 = y - 2;
                if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                    queue.add(new Move(new int[]{x, y, x2, y2}));
                }
            }

            x2 = x;
            y2 = y - 1;
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }

            x2 = x - 1;
            y2 = y - 1;
            if (!moveOutOfBounds(x2, y2)) {
                if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                    queue.add(new Move(new int[]{x, y, x2, y2}));
                }
            }

            x2 = x + 1;
            y2 = y - 1;
            if (!moveOutOfBounds(x2, y2)) {
                if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                    queue.add(new Move(new int[]{x, y, x2, y2}));
                }
            }
        }

        if (!board.getWhitetomove()) {
            if (y == 1) {
                x2 = x;
                y2 = y + 2;
                if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                    queue.add(new Move(new int[]{x, y, x2, y2}));
                }
            }

            x2 = x;
            y2 = y + 1;
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }

            x2 = x - 1;
            y2 = y + 1;
            if (!moveOutOfBounds(x2, y2)){
                if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                    queue.add(new Move(new int[]{x, y, x2, y2}));
                }
            }

            x2 = x + 1;
            y2 = y + 1;
            if (!moveOutOfBounds(x2, y2)){
                if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                    queue.add(new Move(new int[]{x, y, x2, y2}));
                }
            }
        }
    }

    public void generateKnightMoves(Board board, int x, int y) {
        int x2 = 0;
        int y2 = 0;

        x2 = x + 1;
        y2 = y + 2;
        if (!moveOutOfBounds(x2, y2)){
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x + 1;
        y2 = y - 2;
        if (!moveOutOfBounds(x2, y2)){
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x - 1;
        y2 = y + 2;
        if (!moveOutOfBounds(x2, y2)){
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x - 1;
        y2 = y - 2;
        if (!moveOutOfBounds(x2, y2)){
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x + 2;
        y2 = y + 1;
        if (!moveOutOfBounds(x2, y2)){
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x + 2;
        y2 = y - 1;
        if (!moveOutOfBounds(x2, y2)){
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x - 2;
        y2 = y + 1;
        if (!moveOutOfBounds(x2, y2)){
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x - 2;
        y2 = y - 1;
        if (!moveOutOfBounds(x2, y2)){
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
    }

    public void generateRookMoves(Board board, int x, int y) {
        int x2 = 0;
        int y2 = 0;

        y2 = y;
        for (int i = x + 1; i < board.getBoard().length; i++) {
            x2 = i;
            if (!validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                if (board.getBoard()[y2][x2] != 0) {
                    break;
                }
                continue;
            }
            queue.add(new Move(new int[]{x, y, x2, y2}));
        }

        for (int i = x - 1; i >= 0; i--) {
            x2 = i;
            if (!validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                if (board.getBoard()[y2][x2] != 0) {
                    break;
                }
                continue;
            }
            queue.add(new Move(new int[]{x, y, x2, y2}));
        }
        x2 = x;
        for (int i = y + 1; i < board.getBoard().length; i++) {
            y2 = i;
            if (!validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                if (board.getBoard()[y2][x2] != 0) {
                    break;
                }
                continue;
            }
            queue.add(new Move(new int[]{x, y, x2, y2}));
        }

        for (int i = y - 1; i >= 0; i--) {
            y2 = i;
            if (!validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                if (board.getBoard()[y2][x2] != 0) {
                    break;
                }
                continue;
            }
            queue.add(new Move(new int[]{x, y, x2, y2}));
        }
    }

    public void generateBishopMoves(Board board, int x, int y) {
        int x2 = 0;
        int y2 = 0;
        int length = board.getBoard().length;
        for (int i = 1; i < length; i++) {
            if ((x + i >= length) ||
                    (y + i >= length)) {
                break;
            }
            x2 = x + i;
            y2 = y + i;
            if (!validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                if (board.getBoard()[y2][x2] != 0) {
                    break;
                }
                continue;
            }
            queue.add(new Move(new int[]{x, y, x2, y2}));
        }

        for (int i = 1; i < length; i++) {
            if ((x + i >= length) ||
                    (y - i < 0)) {
                break;
            }
            x2 = x + i;
            y2 = y - i;
            if (!validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                if (board.getBoard()[y2][x2] != 0) {
                    break;
                }
                continue;
            }
            queue.add(new Move(new int[]{x, y, x2, y2}));
        }

        for (int i = 1; i < length; i++) {
            if ((x - i < 0) ||
                    (y + i >= length)) {
                break;
            }
            x2 = x - i;
            y2 = y + i;
            if (!validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                if (board.getBoard()[y2][x2] != 0) {
                    break;
                }
                continue;
            }
            queue.add(new Move(new int[]{x, y, x2, y2}));
        }

        for (int i = 1; i < length; i++) {
            if ((x - i < 0) ||
                    (y - i < 0)) {
                break;
            }
            x2 = x - i;
            y2 = y - i;
            if (!validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                if (board.getBoard()[y2][x2] != 0) {
                    break;
                }
                continue;
            }
            queue.add(new Move(new int[]{x, y, x2, y2}));
        }
    }

    public void generateQueenMoves(Board board, int x, int y) {
        generateRookMoves(board, x,  y);
        generateBishopMoves(board, x, y);
    }

    public void generateKingMoves(Board board, int x, int y) {
        int x2 = 0;
        int y2 = 0;

        if (board.getWhitetomove() && !board.isWhitekingmoved()) {
            x2 = 0;
            y2 = 7;
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
            x2 = 7;
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }

        if (!board.getWhitetomove() && !board.isBlackkingmoved()) {
            x2 = 0;
            y2 = 0;
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
            x2 = 7;
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x;
        y2 = y + 1;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        y2 = y - 1;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }

        x2 = x - 1;
        y2 = y;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        y2 = y + 1;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        y2 = y - 1;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }

        x2 = x + 1;
        y2 = y;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        y2 = y + 1;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        y2 = y - 1;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
    }

    public boolean moveOutOfBounds(int x2, int y2) {
        if (x2 < 0 || x2 > 7) {
            return true;
        }
        if (y2 < 0 || y2 > 7) {
            return true;
        }
        return false;
    }
}
