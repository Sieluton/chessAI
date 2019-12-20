package chess.move;

import chess.Board;
import chess.move.MoveValidator;
import chess.structures.MyQueue;

import java.util.ArrayDeque;

public class MoveGenerator {
    public MoveValidator validator = new MoveValidator();
    public MyQueue queue = new MyQueue();

    /**
     * Used to generate all legal moves on a given chess board
     * @param board Board object that stores game state
     * @return Queue of legal moves
     */
    public MyQueue generateMoves(Board board) {
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

    /**
     * Generates moves for pawn in given position on board
     * @param board Board object that stores game state
     * @param x position on x-axis of pawn which moves you want to generate
     * @param y position on y-axis of pawn which moves you want to generate
     */
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
            if (!moveOutOfBounds(x2, y2)) {
                if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                    queue.add(new Move(new int[]{x, y, x2, y2}));
                }
            }

            x2 = x + 1;
            y2 = y + 1;
            if (!moveOutOfBounds(x2, y2)) {
                if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                    queue.add(new Move(new int[]{x, y, x2, y2}));
                }
            }
        }
    }

    /**
     * Generates moves for knight in given position on board
     * @param board Board object that stores game state
     * @param x position on x-axis of knight which moves you want to generate
     * @param y position on y-axis of knight which moves you want to generate
     */
    public void generateKnightMoves(Board board, int x, int y) {
        int x2 = 0;
        int y2 = 0;

        x2 = x + 1;
        y2 = y + 2;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x + 1;
        y2 = y - 2;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x - 1;
        y2 = y + 2;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x - 1;
        y2 = y - 2;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x + 2;
        y2 = y + 1;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x + 2;
        y2 = y - 1;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x - 2;
        y2 = y + 1;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
        x2 = x - 2;
        y2 = y - 1;
        if (!moveOutOfBounds(x2, y2)) {
            if (validator.isValidMove(new Move(new int[]{x, y, x2, y2}), board)) {
                queue.add(new Move(new int[]{x, y, x2, y2}));
            }
        }
    }

    /**
     * Generates moves for rook in given position on board
     * @param board Board object that stores game state
     * @param x position on x-axis of rook which moves you want to generate
     * @param y position on y-axis of rook which moves you want to generate
     */
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

    /**
     * Generates moves for bishop in given position on board
     * @param board Board object that stores game state
     * @param x position on x-axis of bishop which moves you want to generate
     * @param y position on y-axis of bishop which moves you want to generate
     */
    public void generateBishopMoves(Board board, int x, int y) {
        int x2 = 0;
        int y2 = 0;
        int length = board.getBoard().length;
        for (int i = 1; i < length; i++) {
            if ((x + i >= length)
                    || (y + i >= length)) {
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
            if ((x + i >= length)
                    || (y - i < 0)) {
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
            if ((x - i < 0)
                    || (y + i >= length)) {
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
            if ((x - i < 0)
                    || (y - i < 0)) {
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

    /**
     * Generates moves for queen in given position on board
     * @param board Board object that stores game state
     * @param x position on x-axis of queen which moves you want to generate
     * @param y position on y-axis of queen which moves you want to generate
     */
    public void generateQueenMoves(Board board, int x, int y) {
        generateRookMoves(board, x,  y);
        generateBishopMoves(board, x, y);
    }

    /**
     * Generates moves for king in given position on board
     * @param board Board object that stores game state
     * @param x position on x-axis of king which moves you want to generate
     * @param y position on y-axis of king which moves you want to generate
     */
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

    /**
     * Checks if given coordinates point outside of board
     * @param x coordinate in x-axis
     * @param y coordinate in y-axis
     * @return True if move is out of bounds
     */
    public boolean moveOutOfBounds(int x, int y) {
        if (x < 0 || x > 7) {
            return true;
        }
        if (y < 0 || y > 7) {
            return true;
        }
        return false;
    }
}
