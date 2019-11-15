package chess.move;

import chess.Board;

public class MoveValidator {
    private PawnRules pawnRules = new PawnRules();

    public Boolean isValidMove(Move move, Board board){
        if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 1){
            return pawnRules.isValidPawnMove(move, board);
        }
        else if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 2){
            return true;
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

    public Boolean isPawnMove(Move move, Board board){
        if (Math.abs(board.getBoard()[move.getMove()[1]][move.getMove()[0]]) == 1){
            return pawnRules.isValidPawnMove(move, board);
        }
        return false;
    }
}
