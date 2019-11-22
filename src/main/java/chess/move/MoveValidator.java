package chess.move;

import chess.Board;
import chess.move.rules.PawnRules;
import chess.move.rules.RookRules;

public class MoveValidator {
    public PawnRules pawnRules = new PawnRules();
    public RookRules rookRules = new RookRules();

    public boolean isValidMove(Move move, Board board){
        if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 1){
            return pawnRules.isValidMove(move, board);
        }
        else if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 2){
            return rookRules.isValidMove(move, board);
        }
        else if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 3){
            return true;
        }
        else if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 4){
            return true;
        }
        else if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 5){
            return true;
        }
        else if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 6){
            return true;
        }
        return false;
    }

    public boolean isPawnMove(Move move, Board board){
        if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 1){
            return pawnRules.isValidMove(move, board);
        }
        return false;
    }

    public boolean isRookMove(Move move, Board board){
        if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 2){
            return rookRules.isValidMove(move, board);
        }
        return false;
    }
}
