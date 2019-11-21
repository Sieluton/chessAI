package chess.move.rules;

import chess.Board;
import chess.move.Move;

public class PawnRules {

    /**
     *
     * @param move move to check
     * @param board current game state
     * @return true if it is valid move for pawn
     */
    public boolean isValidPawnMove(Move move, Board board){
        if (takeCheck(move, board) || moveCheck(move, board) || doubleMoveCheck(move, board))
            return true;
        return false;
    }

    /**
     *
     * @param move move to check
     * @param board current game state
     * @return true if move is en passant take
     */
    public boolean enPassantCheck(Move move, Board board){
        if (board.getWhitetomove()){
            if (takeCheck(move, board) && board.getBoard()[move.getMove()[3]][move.getMove()[2]] == 7)
                return true;
        }
        else {
            if (takeCheck(move, board) && board.getBoard()[move.getMove()[3]][move.getMove()[2]] == -7)
                return true;
        }
        return false;
    }

    /**
     *
     * @param move move to check
     * @param board current game state
     * @return true if move would lead to promotion
     */
    public boolean promotionCheck(Move move, Board board){
        if (board.getWhitetomove()){
            if (isValidPawnMove(move, board) && move.getMove()[3] == 0)
                return true;
        }
        else {
            if (isValidPawnMove(move, board) && move.getMove()[3] == 7)
                return true;
        }
        return false;
    }

    /**
     *
     * @param move move to check
     * @param board current game state
     * @return true if pawn can move 1 step forward
     */
    public boolean moveCheck(Move move, Board board){
        if (board.getWhitetomove()){
            if (move.getMove()[1] - move.getMove()[3] == 1 && move.getMove()[0] == move.getMove()[2] &&
                    board.getBoard()[move.getMove()[3]][move.getMove()[2]] == 0 &&
                    board.getBoard()[move.getMove()[1]][move.getMove()[0]] == -1)
                return true;
        }
        else {
            if (move.getMove()[1] - move.getMove()[3] == -1 && move.getMove()[0] == move.getMove()[2] &&
                    board.getBoard()[move.getMove()[3]][move.getMove()[2]] == 0 &&
                    board.getBoard()[move.getMove()[1]][move.getMove()[0]] == 1)
                return true;
        }
        return false;
    }

    /**
     *
     * @param move move to check
     * @param board current game state
     * @return true if pawn can move 2 steps forward
     */
    public boolean doubleMoveCheck(Move move, Board board){
        if (board.getWhitetomove()){
            if (move.getMove()[1] - move.getMove()[3] == 2 && move.getMove()[0] == move.getMove()[2] &&
                    board.getBoard()[move.getMove()[3]][move.getMove()[2]] == 0 &&
                    board.getBoard()[move.getMove()[3]+1][move.getMove()[2]] == 0 && move.getMove()[1] == 6 &&
                    board.getBoard()[move.getMove()[1]][move.getMove()[0]] == -1)
                return true;
        }
        else {
            if (move.getMove()[1] - move.getMove()[3] == -2 && move.getMove()[0] == move.getMove()[2] &&
                    board.getBoard()[move.getMove()[3]][move.getMove()[2]] == 0 &&
                    board.getBoard()[move.getMove()[3]-1][move.getMove()[2]] == 0 && move.getMove()[1] == 1 &&
                    board.getBoard()[move.getMove()[1]][move.getMove()[0]] == 1)
                return true;
        }
        return false;
    }

    /**
     *
     * @param move move to check
     * @param board current game state
     * @return true if pawn can take enemy piece on left or right side
     */
    public boolean takeCheck(Move move, Board board){
        if (board.getWhitetomove()){
            if (move.getMove()[1] - move.getMove()[3] == 1 &&
                    (move.getMove()[0] - move.getMove()[2] == 1 || move.getMove()[0] - move.getMove()[2] == -1) &&
                    board.getBoard()[move.getMove()[3]][move.getMove()[2]] >= 1 &&
                    board.getBoard()[move.getMove()[1]][move.getMove()[0]] == -1)
                return true;
        }
        else {
            if (move.getMove()[1] - move.getMove()[3] == -1 &&
                    (move.getMove()[0] - move.getMove()[2] == 1 || move.getMove()[0] - move.getMove()[2] == -1) &&
                    board.getBoard()[move.getMove()[3]][move.getMove()[2]] <= -1 &&
                    board.getBoard()[move.getMove()[1]][move.getMove()[0]] == 1)
                return true;
        }
        return false;
    }
}
