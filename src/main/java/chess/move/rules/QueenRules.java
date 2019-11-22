package chess.move.rules;

import chess.Board;
import chess.move.Move;

public class QueenRules {
    public RookRules rookrules = new RookRules();
    public BishopRules bishoprules = new BishopRules();

    public boolean isValidMove(Move move, Board board){
        if (board.getWhitetomove() &&
                board.getBoard()[move.getMove()[1]][move.getMove()[0]] == -5 &&
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] >= 0){
            return moveCheck(move, board);
        }
        else if (!board.getWhitetomove() &&
                board.getBoard()[move.getMove()[1]][move.getMove()[0]] == 5 &&
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] <= 0){
            return moveCheck(move, board);
        }
        return false;
    }

    public boolean moveCheck(Move move, Board board){
        if (rookrules.moveCheck(move, board)) return true;
        else if (bishoprules.moveCheck(move, board)) return true;
        return false;
    }
}
