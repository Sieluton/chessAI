package chess.move.rules;

import chess.Board;
import chess.move.Move;

public class BishopRules {

    public boolean isValidMove(Move move, Board board){
        if (board.getWhitetomove() &&
                board.getBoard()[move.getMove()[1]][move.getMove()[0]] == -4 &&
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] >= 0){
            return moveCheck(move, board);
        }
        else if (!board.getWhitetomove() &&
                board.getBoard()[move.getMove()[1]][move.getMove()[0]] == 4 &&
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] <= 0){
            return moveCheck(move, board);
        }
        return false;
    }

    public boolean moveCheck(Move move, Board board){
        int a = move.getMove()[0] - move.getMove()[2];
        int b = move.getMove()[1] - move.getMove()[3];
        if (a < 0) a *= -1;
        if (b < 0) b *= -1;
        if (a != b) return false;
        if (move.getMove()[0] == move.getMove()[2] || move.getMove()[1] == move.getMove()[3]) return false;
        if (noPieceIsBlocking(move, board)){
            return true;
        }
        return false;
    }

    public boolean noPieceIsBlocking(Move move, Board board){
        int x1 = move.getMove()[0];
        int x2 = move.getMove()[2];
        int y1 = move.getMove()[1];
        int y2 = move.getMove()[3];
        if (x1 < x2 && y1 < y2){
            for (int i = 1; i < x2-x1; i++){
                if (board.getBoard()[y1+i][x1+i] != 0) return false;
            }
        }
        else if (x1 < x2 && y1 > y2){
            for (int i = 1; i < x2-x1; i++){
                if (board.getBoard()[y1-i][x1+i] != 0) return false;
            }
        }
        else if (x1 > x2 && y1 < y2){
            for (int i = 1; i < x1-x2; i++){
                if (board.getBoard()[y1+i][x1-i] != 0) return false;
            }
        }
        else if (x1 > x2 && y1 > y2){
            for (int i = 1; i < x1-x2; i++){
                if (board.getBoard()[y1-i][x1-i] != 0) return false;
            }
        }
        return true;
    }
}
