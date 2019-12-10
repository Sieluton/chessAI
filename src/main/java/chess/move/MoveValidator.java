package chess.move;

import chess.Board;
import chess.move.pieces.*;
import chess.move.rules.*;

public class MoveValidator {
    public PawnRules pawnrules = new PawnRules();
    public RookRules rookrules = new RookRules();
    public KnightRules knightrules = new KnightRules();
    public BishopRules bishoprules = new BishopRules();
    public QueenRules queenrules = new QueenRules();
    public KingRules kingrules = new KingRules();
    public PawnMoves pawnmoves = new PawnMoves();
    public RookMoves rookmoves = new RookMoves();
    public KnightMoves knightmoves = new KnightMoves();
    public BishopMoves bishopmoves = new BishopMoves();
    public QueenMoves queenmoves = new QueenMoves();
    public KingMoves kingmoves = new KingMoves();

    /**
     * Checks if start square contains specific piece and then checks is it valid move for that piece.
     * Used to help MoveGenerator.
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if given move is valid move for any piece
     */
    public boolean isValidMove(Move move, Board board) {
        Board copyboard = new Board(board);
        if (pawnrules.isValidMove(move, board)) {
            pawnmoves.makeMove(move, copyboard);
            if (isKingThreatened(copyboard)) {
                return false;
            }
            return true;
        } else if (rookrules.isValidMove(move, board)) {
            rookmoves.makeMove(move, copyboard);
            if (isKingThreatened(copyboard)) {
                return false;
            }
            return true;
        } else if (knightrules.isValidMove(move, board)) {
            knightmoves.makeMove(move, copyboard);
            if (isKingThreatened(copyboard)) {
                return false;
            }
            return true;
        } else if (bishoprules.isValidMove(move, board)) {
            bishopmoves.makeMove(move, copyboard);
            if (isKingThreatened(copyboard)) {
                return false;
            }
            return true;
        } else if (queenrules.isValidMove(move, board)) {
            queenmoves.makeMove(move, copyboard);
            if (isKingThreatened(copyboard)) {
                return false;
            }
            return true;
        } else if (kingrules.isValidMove(move, board)) {
            kingmoves.makeMove(move, copyboard);
            if (isKingThreatened(copyboard)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Checks is start square pawn and then is given move legit move for it
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid pawn move
     */
    public boolean isPawnMove(Move move, Board board) {
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 1 || piece == -1) {
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
    public boolean isRookMove(Move move, Board board) {
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 2 || piece == -2) {
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
    public boolean isKnightMove(Move move, Board board) {
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 3 || piece == -3) {
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
    public boolean isBishopMove(Move move, Board board) {
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 4 || piece == -4) {
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
    public boolean isQueenMove(Move move, Board board) {
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 5 || piece == -5) {
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
    public boolean isKingMove(Move move, Board board) {
        int piece = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        if (piece == 6 || piece == -6) {
            return kingrules.isValidMove(move, board);
        }
        return false;
    }

    /**
     * Used to check if king under attack after move
     * @param board Board object that stores game state
     * @return True if king is under attack
     */
    public boolean isKingThreatened(Board board) {
        board.changeTurn();
        if (board.getWhitetomove()) {
            return kingrules.isSquareUnderAttack(board, board.whitekingpos[0], board.whitekingpos[1]);
        }
        return kingrules.isSquareUnderAttack(board, board.blackkingpos[0], board.blackkingpos[1]);
    }
}
