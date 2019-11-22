package chess.move.rules;

import chess.Board;
import chess.move.Move;

public class RookRules {

    public boolean isValidMove(Move move, Board board){
        if (board.getWhitetomove() &&
                board.getBoard()[move.getMove()[1]][move.getMove()[0]] == -2 &&
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] >= 0){
            return moveCheck(move, board);
        }
        else if (!board.getWhitetomove() &&
                board.getBoard()[move.getMove()[1]][move.getMove()[0]] == 2 &&
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] <= 0){
            return moveCheck(move, board);
        }
        return false;
    }

    public boolean moveCheck(Move move, Board board){
        if (move.getMove()[0] != move.getMove()[2] &&
                move.getMove()[1] != move.getMove()[3]){
            return false;
        }
        if (noPieceIsBlocking(move, board)){
            return true;
        }
        return false;
    }

    public boolean noPieceIsBlocking(Move move, Board board){
        int i, j; // used to check squares between
        boolean axis; // value true means x-axis and false y-axis
        if (move.getMove()[1] < move.getMove()[3]){
            i = move.getMove()[1];
            j = move.getMove()[3];
            axis = false;
        }
        else if (move.getMove()[1] > move.getMove()[3]){
            i = move.getMove()[3];
            j = move.getMove()[1];
            axis = false;
        }
        else if (move.getMove()[0] < move.getMove()[2]){
            i = move.getMove()[0];
            j = move.getMove()[2];
            axis = true;
        }
        else if (move.getMove()[0] > move.getMove()[2]){
            i = move.getMove()[2];
            j = move.getMove()[0];
            axis = true;
        }
        else return false; // in case something goes wrong
        for (i++; i < j; i++){ // loop over all squares the rook moves over and check if they are empty
            if (axis && board.getBoard()[move.getMove()[1]][i] != 0) return false;
            else if (!axis && board.getBoard()[i][move.getMove()[0]] != 0) return false;
        }
        return true;
    }
}
