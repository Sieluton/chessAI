package chess.move.rules;

import chess.Board;
import chess.move.Move;

public class KingRules {

    /**
     * If start square contains given piece and end square is empty or enemy
     * piece then proceed to check if move is valid and return that. Else false.
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid
     */
    public boolean isValidMove(Move move, Board board) {
        return false;
    }

    /**
     * Checks if given square is under attack by enemy piece
     * @param board Board object that stores game state
     * @param x int of column
     * @param y int of row
     * @return True if given square is under attack
     */
    public boolean isSquareUnderAttack(Board board, int x, int y) {

        return false;
    }

    /**
     * Checks if given square is under attack in single axis
     * @param board Board object that stores game state
     * @param x int of column
     * @param y int of row
     * @return True if given square is under attack in same row or column
     */
    public boolean isSquareUnderAttackSingleAxis(Board board, int x, int y) {
        int[][] game = board.getBoard();
        //Checks if square under attack by queen, rook or bishop
        for (int i = 1; y + i < game.length; i++) {

        }
        return false;
    }

    /**
     * Checks if given square is under attack in diagonal
     * @param board Board object that stores game state
     * @param x int of column
     * @param y int of row
     * @return True if given square is under attack in diagonal
     */
    public boolean isSquareUnderAttackDiagonal(Board board, int x, int y) {
        int[][] game = board.getBoard();
        //Check if under attack by pawn or king in left diagonal
        if (y + 1 < game.length && x - 1 >= 0) {
            int square = game[y + 1][x - 1];
            if (board.getWhitetomove() &&
                    (square == 6)) {
                return true;
            }
            if (!board.getWhitetomove() &&
                    (square == -1 || square == -6)) {
                return true;
            }
        }
        if (y - 1 >= 0 && x - 1 >= 0) {
            int square = game[y - 1][x - 1];
            if (board.getWhitetomove() &&
                    (square == 1 || square == 6)) {
                return true;
            }
            if (!board.getWhitetomove() &&
                    (square == -6)) {
                return true;
            }
        }
        //Check if under attack by pawn or king in right diagonal
        if (y + 1 < game.length && x + 1 < game.length) {
            int square = game[y + 1][x + 1];
            if (board.getWhitetomove() &&
                    (square == 6)) {
                return true;
            }
            if (!board.getWhitetomove() &&
                    (square == -1 || square == -6)) {
                return true;
            }
        }
        if (y - 1 >= 0 && x + 1 < game.length) {
            int square = game[y - 1][x + 1];
            if (board.getWhitetomove() &&
                    (square == 1 || square == 6)) {
                return true;
            }
            if (!board.getWhitetomove() &&
                    (square == -6)) {
                return true;
            }
        }
        //Checks if square under attack by queen or bishop
        for (int i = 1; y + i < game.length; i++) {

        }
        return false;
    }

    /**
     * Checks if given square is under attack in single axis by rook or queen
     * @param board Board object that stores game state
     * @param x int of column
     * @param y int of row
     * @return True if given square is under attack
     */
    public boolean isSquareUnderAttackKnight(Board board, int x, int y) {
        int[][] game = board.getBoard();
        if (y + 2 < game.length && x + 1 < game.length) {
            int square = game[y + 2][x + 1];
            if (square == 3 && board.getWhitetomove()) {
                return true;
            }
            if (square == -3 && !board.getWhitetomove()) {
                return true;
            }
        }
        if (y + 1 < game.length && x + 2 < game.length) {
            int square = game[y + 1][x + 2];
            if (square == 3 && board.getWhitetomove()) {
                return true;
            }
            if (square == -3 && !board.getWhitetomove()) {
                return true;
            }
        }
        if (y - 2 >= 0 && x + 1 < game.length) {
            int square = game[y - 2][x + 1];
            if (square == 3 && board.getWhitetomove()) {
                return true;
            }
            if (square == -3 && !board.getWhitetomove()) {
                return true;
            }
        }
        if (y - 1 >= 0 && x + 2 < game.length) {
            int square = game[y - 1][x + 2];
            if (square == 3 && board.getWhitetomove()) {
                return true;
            }
            if (square == -3 && !board.getWhitetomove()) {
                return true;
            }
        }
        if (y + 2 < game.length && x - 1 >= 0) {
            int square = game[y + 2][x - 1];
            if (square == 3 && board.getWhitetomove()) {
                return true;
            }
            if (square == -3 && !board.getWhitetomove()) {
                return true;
            }
        }
        if (y + 1 < game.length && x - 2 >= 0) {
            int square = game[y + 1][x - 2];
            if (square == 3 && board.getWhitetomove()) {
                return true;
            }
            if (square == -3 && !board.getWhitetomove()) {
                return true;
            }
        }
        if (y - 2 >= 0 && x - 1 >= 0) {
            int square = game[y - 2][x - 1];
            if (square == 3 && board.getWhitetomove()) {
                return true;
            }
            if (square == -3 && !board.getWhitetomove()) {
                return true;
            }
        }
        if (y - 1 >= 0 && x - 2 >= 0) {
            int square = game[y - 1][x - 2];
            if (square == 3 && board.getWhitetomove()) {
                return true;
            }
            if (square == -3 && !board.getWhitetomove()) {
                return true;
            }
        }
        return false;
    }
}
