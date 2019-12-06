package chess.move.rules;

import chess.Board;
import chess.move.Move;
import chess.structures.MathFunctions;

public class KingRules {
    MathFunctions math = new MathFunctions();

    /**
     * If start square contains given piece and end square is empty or enemy
     * piece then proceed to check if move is valid and return that. Else false.
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid
     */
    public boolean isValidMove(Move move, Board board) {
        int startsquare = board.getBoard()[move.getMove()[1]][move.getMove()[0]]; //Stores value of start square
        int endsquare = board.getBoard()[move.getMove()[3]][move.getMove()[2]]; //Stores value of end square
        //Check that start square is white king and end square is empty, black piece or own rook
        if (board.getWhitetomove() && //Check is it whites turn
                startsquare == -6 && //Check does start square contain white king
                (endsquare >= 0 || endsquare == -2)) { //Check is end square empty, black piece or own rook
            return moveCheck(move, board);
        }
        //Check that start square is black king and end square is empty, white piece or own rook
        else if (!board.getWhitetomove() && //Check is it blacks turn
                startsquare == 6 && //Check does start square contain black king
                (endsquare <= 0 || endsquare == 2)) { //Check is end square empty, white piece or own rook
            return moveCheck(move, board);
        }
        return false;
    }

    /**
     * Checks that given move is allowed for this piece
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is allowed
     */
    public boolean moveCheck(Move move, Board board) {
        int movex = math.abs(move.getMove()[0] - move.getMove()[2]);
        int movey = math.abs(move.getMove()[1] - move.getMove()[3]);
        if (isCastling(move, board)) {
            return true;
        }
        if ((movex == 1 || movex == 0) &&
                (movey == 1 || movey == 0) &&
        !isSquareUnderAttack(board, move.getMove()[2], move.getMove()[3])) {
            return true;
        }
        return false;
    }

    /**
     * Checks if move is legal castling move
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is legal castling move
     */
    public boolean isCastling(Move move, Board board) {
        int x = move.getMove()[0];
        int y = move.getMove()[1];
        int endsquare = board.getBoard()[move.getMove()[3]][move.getMove()[2]];
        if (board.getWhitetomove() &&
                !board.isWhitekingmoved() &&
                endsquare == -2) {
            if (move.getMove()[2] == 0 &&
                    !board.isWhiteleftrookmoved()) {
                return checkSquaresCastling(board, x, y, true);
            }
            if (move.getMove()[2] == 7 &&
                    !board.isWhiterightrookmoved()) {
                return checkSquaresCastling(board, x, y, false);
            }
        }
        if (!board.getWhitetomove() &&
                !board.isBlackkingmoved() &&
                endsquare == 2) {
            if (move.getMove()[2] == 0 &&
                    !board.isBlackleftrookmoved()) {
                return checkSquaresCastling(board, x, y, true);
            }
            if (move.getMove()[2] == 7 &&
                    !board.isBlackrightrookmoved()) {
                return checkSquaresCastling(board, x, y, false);
            }
        }
        return false;
    }

    /**
     * Checks if squares are legal to castle over
     * @param board Board object that stores game state
     * @param x int value of start square's x-axis value
     * @param y int value of start square's y-axis value
     * @param left boolean that true if left side check, else checks right
     * @return True if square are empty and not under threat
     */
    public boolean checkSquaresCastling(Board board, int x, int y, boolean left) {
        int[][] game = board.getBoard();
        if (left) {
            if (game[y][x - 1] != 0 ||
                    game[y][x - 2] != 0 ||
                    game[y][x - 3] != 0) {
                return false;
            }
            if (isSquareUnderAttack(board, x, y) ||
                    isSquareUnderAttack(board, x - 1, y) ||
                    isSquareUnderAttack(board, x - 2, y)) {
                return false;
            }
        }
        else {
            if (game[y][x + 1] != 0 ||
                    game[y][x + 2] != 0) {
                return false;
            }
            if (isSquareUnderAttack(board, x, y) ||
                    isSquareUnderAttack(board, x + 1, y) ||
                    isSquareUnderAttack(board, x + 2, y)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if given square is under attack by enemy piece
     * @param board Board object that stores game state
     * @param x int of column
     * @param y int of row
     * @return True if given square is under attack
     */
    public boolean isSquareUnderAttack(Board board, int x, int y) {
        if (isSquareUnderAttackDiagonal(board, x, y) ||
                isSquareUnderAttackSingleAxis(board, x, y) ||
                isSquareUnderAttackKnight(board, x, y)) {
            return true;
        }
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
        int square = 0;
        //Checks if square under attack by queen or rook
        for (int i = 1; y + i < game.length; i++) {
            square = game[y + i][x];
            if (square == 0 ||
                    (board.getWhitetomove() && square == -6) ||
                    (!board.getWhitetomove() && square == 6)) {
                continue;
            }
            if (checkSingleAxisForThreat(board, square, i)) {
                return true;
            }
            break;
        }

        for (int i = 1; x + i < game.length; i++) {
            square = game[y][x + i];
            if (square == 0 ||
                    (board.getWhitetomove() && square == -6) ||
                    (!board.getWhitetomove() && square == 6)) {
                continue;
            }
            if (checkSingleAxisForThreat(board, square, i)) {
                return true;
            }
            break;
        }

        for (int i = 1; y - i >= 0; i++) {
            square = game[y - i][x];
            if (square == 0 ||
                    (board.getWhitetomove() && square == -6) ||
                    (!board.getWhitetomove() && square == 6)) {
                continue;
            }
            if (checkSingleAxisForThreat(board, square, i)) {
                return true;
            }
            break;
        }

        for (int i = 1; x - i >= 0; i++) {
            square = game[y][x - i];
            if (square == 0 ||
                    (board.getWhitetomove() && square == -6) ||
                    (!board.getWhitetomove() && square == 6)) {
                continue;
            }
            if (checkSingleAxisForThreat(board, square, i)) {
                return true;
            }
            break;
        }
        return false;
    }

    /**
     * Check if given square threatens start square in single axis
     * @param board Board object that stores game state
     * @param square int value of square to be checked
     * @param distance int value of distance from start square
     * @return Return true if contains piece that threatens start square
     */
    private boolean checkSingleAxisForThreat(Board board, int square, int distance) {
        if (board.getWhitetomove()) {
            if (distance == 1 && square == 6) {
                return true;
            }
            if (square == 5 || square == 2) {
                return true;
            }
        }
        else if (!board.getWhitetomove()) {
            if (distance == 1 && square == -6) {
                return true;
            }
            if (square == -5 || square == -2) {
                return true;
            }
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
        int square = 0;
        for (int i = 1; y + i < game.length; i++) {
            if (x + i < game.length) {
                square = game[y + i][x + i];
                if (square == 0 ||
                        (board.getWhitetomove() && square == -6) ||
                        (!board.getWhitetomove() && square == 6)) {
                    continue;
                }
                if (checkDiagonalSquareForThreat(board, square, i, true)) {
                    return true;
                }
                break;
            }
            break;
        }

        for (int i = 1; y + i < game.length; i++) {
            if (x - i >= 0) {
                square = game[y + i][x - i];
                if (square == 0 ||
                        (board.getWhitetomove() && square == -6) ||
                        (!board.getWhitetomove() && square == 6)) {
                    continue;
                }
                else if (checkDiagonalSquareForThreat(board, square, i, true)) {
                    return true;
                }
                break;
            }
            break;
        }

        for (int i = 1; y - i >= 0; i++) {
            if (x + i < game.length) {
                square = game[y - i][x + i];
                if (square == 0 ||
                        (board.getWhitetomove() && square == -6) ||
                        (!board.getWhitetomove() && square == 6)) {
                    continue;
                }
                else if (checkDiagonalSquareForThreat(board, square, i, false)) {
                    return true;
                }
                break;
            }
            break;
        }

        for (int i = 1; y - i >= 0; i++) {
            if (x - i >= 0) {
                square = game[y - i][x - i];
                if (square == 0 ||
                        (board.getWhitetomove() && square == -6) ||
                        (!board.getWhitetomove() && square == 6)) {
                    continue;
                }
                else if (checkDiagonalSquareForThreat(board, square, i, false)) {
                    return true;
                }
                break;
            }
            break;
        }
        return false;
    }

    /**
     * Used to check if this square contains piece that threatens start square in diagonal
     * @param square int value of square to check
     * @param distance int value how far away from start square
     * @param rising boolean value of are we going up or down board
     * @param board Board object that stores game state
     * @return True if this square contains piece threatens this start square in diagonal
     */
    private boolean checkDiagonalSquareForThreat(Board board, int square, int distance, boolean rising) {
        if (board.getWhitetomove()) {
            //Checks if square is one away from destination square
            if (distance == 1) {
                //Checks is there black king in square
                if (square == 6) {
                    return true;
                }
                //Checks is square threatened by black pawn
                if (!rising && square == 1) {
                    return true;
                }
            }
            //Checks square threatened by black queen or bishop
            if (square == 4 || square == 5) {
                return true;
            }
        }
        else if (!board.getWhitetomove()) {
            //Checks if square is one away from destination square
            if (distance == 1) {
                //Checks is square threatened by white king
                if (square == -6) {
                    return true;
                }
                //Checks is square threatened by white pawn
                if (rising && square == -1) {
                    return true;
                }
            }
            //Checks square threatened by white queen or bishop
            if (square == -4 || square == -5) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if given square is under attack by enemy knight
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