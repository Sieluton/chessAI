package chess.move.pieces;

import chess.Board;
import chess.move.Move;
import chess.move.rules.KingRules;

public class KingMoves {
    public KingRules kingrules = new KingRules();

    /**
     * Used to make move on given piece
     * @param move Move object contains move
     * @param board Board object that stores game state
     */
    public void makeMove(Move move, Board board) {
        if (kingrules.isCastling(move, board)) {
            castling(move, board);
        } else {
            move(move, board);
        }
        if (board.getWhitetomove()) {
            board.setWhitekingmoved(true);
        } else {
            board.setBlackkingmoved(true);
        }
        board.changeTurn();
    }

    /**
     * Given move copies value of start square to end square and empties start square
     * @param move Move object contains move
     * @param board Board object that stores game state
     */
    public void move(Move move, Board board) {
        int[][] game = board.getBoard(); //Store chessboard to edit
        game[move.getMove()[3]][move.getMove()[2]] = game[move.getMove()[1]][move.getMove()[0]];
        game[move.getMove()[1]][move.getMove()[0]] = 0; //Empty start square
        board.setBoard(game); //Make edited chessboard to current chessboard
        updateKingPos(board, move.getMove()[2], move.getMove()[3]);
    }

    /**
     * Handles castling move
     * @param move Move object contains move
     * @param board Board object that stores game state
     */
    public void castling(Move move, Board board) {
        int[][] game = board.getBoard();
        if (move.getMove()[2] == 0) {
            game[move.getMove()[1]][move.getMove()[0] - 2] = game[move.getMove()[1]][move.getMove()[0]];
            game[move.getMove()[1]][move.getMove()[0] - 1] = game[move.getMove()[3]][move.getMove()[2]];
            updateKingPos(board, move.getMove()[0] - 2, move.getMove()[1]);
        } else {
            game[move.getMove()[1]][move.getMove()[0] + 2] = game[move.getMove()[1]][move.getMove()[0]];
            game[move.getMove()[1]][move.getMove()[0] + 1] = game[move.getMove()[3]][move.getMove()[2]];
            updateKingPos(board, move.getMove()[0] + 2, move.getMove()[1]);
        }
        game[move.getMove()[1]][move.getMove()[0]] = 0;
        game[move.getMove()[3]][move.getMove()[2]] = 0;
    }

    /**
     * Updates kings position after move
     * @param x int kings position in x-axis
     * @param y int kings position in y-axis
     */
    public void updateKingPos(Board board, int x, int y) {
        if (board.getWhitetomove()) {
            board.whitekingpos[0] = x;
            board.whitekingpos[1] = y;
        }
        else if (!board.getWhitetomove()) {
            board.blackkingpos[0] = x;
            board.blackkingpos[1] = y;
        }
    }
}
