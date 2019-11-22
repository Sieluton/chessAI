package chess.move;

import chess.Board;
import chess.move.rules.*;

public class MoveValidator {
    public PawnRules pawnrules = new PawnRules();
    public RookRules rookrules = new RookRules();
    public KnightRules knightrules = new KnightRules();
    public BishopRules bishoprules = new BishopRules();
    public QueenRules queenrules = new QueenRules();
    public KingRules kingrules = new KingRules();

    public boolean isValidMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 1 || piece == -1){
            return pawnrules.isValidMove(move, board);
        }
        else if (piece == 2 || piece == -2){
            return rookrules.isValidMove(move, board);
        }
        else if (piece == 3 || piece == -3){
            return knightrules.isValidMove(move, board);
        }
        else if (piece == 4 || piece == -4){
            return bishoprules.isValidMove(move, board);
        }
        else if (piece == 5 || piece == -5){
            return queenrules.isValidMove(move, board);
        }
        else if (piece == 6 || piece == -6){
            return kingrules.isValidMove(move, board);
        }
        return false;
    }

    public boolean isPawnMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 1 || piece == -1){
            return pawnrules.isValidMove(move, board);
        }
        return false;
    }

    public boolean isRookMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 2 || piece == -2){
            return rookrules.isValidMove(move, board);
        }
        return false;
    }

    public boolean isKnightMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 3 || piece == -3){
            return knightrules.isValidMove(move, board);
        }
        return false;
    }

    public boolean isBishopMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 4 || piece == -4){
            return bishoprules.isValidMove(move, board);
        }
        return false;
    }

    public boolean isQueenMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 5 || piece == -5){
            return queenrules.isValidMove(move, board);
        }
        return false;
    }

    public boolean isKingMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 6 || piece == -6){
            return kingrules.isValidMove(move, board);
        }
        return false;
    }
}
