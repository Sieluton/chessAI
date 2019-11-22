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

    /**
     * Checks if start square contains specific piece and then checks is it valid move for that piece
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if given move is valid move for any piece
     */
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

    /**
     * Checks is start square pawn and then is given move legit move for it
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid pawn move
     */
    public boolean isPawnMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 1 || piece == -1){
            return pawnrules.isValidMove(move, board);
        }
        return false;
    }

    /**
     * Checks is start square rook and then is given move legit move for it
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid rook move
     */
    public boolean isRookMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 2 || piece == -2){
            return rookrules.isValidMove(move, board);
        }
        return false;
    }

    /**
     * Checks is start square knight and then is given move legit move for it
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid knight move
     */
    public boolean isKnightMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 3 || piece == -3){
            return knightrules.isValidMove(move, board);
        }
        return false;
    }

    /**
     * Checks is start square bishop and then is given move legit move for it
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid bishop move
     */
    public boolean isBishopMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 4 || piece == -4){
            return bishoprules.isValidMove(move, board);
        }
        return false;
    }

    /**
     * Checks is start square queen and then is given move legit move for it
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid queen move
     */
    public boolean isQueenMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 5 || piece == -5){
            return queenrules.isValidMove(move, board);
        }
        return false;
    }

    /**
     * Checks is start square king and then is given move legit move for it
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid king move
     */
    public boolean isKingMove(Move move, Board board){
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 6 || piece == -6){
            return kingrules.isValidMove(move, board);
        }
        return false;
    }
}
