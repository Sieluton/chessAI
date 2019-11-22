package chess.move.rules;

import chess.Board;
import chess.move.Move;

public class KnightRules {

    public boolean isValidMove(Move move, Board board){
        return moveCheck(move, board);
    }

    public boolean moveCheck(Move move, Board board){
        if (board.getBoard()[move.getMove()[1]][move.getMove()[0]] == -3 &&
                board.getWhitetomove() &&
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] >= 0 &&
        moveCorrectAmount(move)){
            return true;
        }
        else if (board.getBoard()[move.getMove()[1]][move.getMove()[0]] == 3 &&
                !board.getWhitetomove() &&
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] <= 0 &&
        moveCorrectAmount(move)){
            return true;
        }
        return false;
    }

    public boolean moveCorrectAmount(Move move){
        int a = move.getMove()[0] - move.getMove()[2];
        int b = move.getMove()[1] - move.getMove()[3];
        if (a < 0) a *= -1;
        if (b < 0) b *= -1;
        if ((a == 2 && b == 1) ||
                (a == 1 && b == 2)){
            return true;
        }
        return false;
    }
}
