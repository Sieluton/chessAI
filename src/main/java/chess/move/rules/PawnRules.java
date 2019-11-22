package chess.move.rules;

import chess.Board;
import chess.move.Move;
import chess.structures.MathFunctions;

public class PawnRules {
    public MathFunctions math = new MathFunctions();

    /**
     * If start square contains given piece and end square is empty or enemy
     * piece then proceed to check if move is valid and return that. Else false.
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid
     */
    public boolean isValidMove(Move move, Board board){
        int startsquare = board.getBoard()[move.getMove()[1]][move.getMove()[0]]; //Stores value of start square
        int endsquare = board.getBoard()[move.getMove()[3]][move.getMove()[2]]; //Stores value of end square
        //Check that start square is white pawn and end square is empty or black piece
        if (board.getWhitetomove() && //Check is it whites turn
                startsquare == -1 && //Check does start square contain white pawn
                endsquare >= 0){ //Check is end square empty or black piece
            return moveCheck(move, board);
        }
        //Check that start square is black pawn and end square is empty or white piece
        else if (!board.getWhitetomove() && //Check is it blacks turn
                startsquare == 1 && //Check does start square contain black pawn
                endsquare <= 0){ //Check is end square empty or white piece
            return moveCheck(move, board);
        }
        return false;
    }

    /**
     * Check if given move is en passant take
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is en passant take
     */
    public boolean enPassantCheck(Move move, Board board){
        int endsquare = board.getBoard()[move.getMove()[3]][move.getMove()[2]]; //Stores value of end square
        //Check that move is take and en passant is allowed for white
        if (board.getWhitetomove() && //Check is it whites turn
                takeCheck(move, board) && //Check is move take
                endsquare == 7) { //Check is end square en passant take allowing
            return true;
        }
        //Check that move is take and en passant is allowed for black
        else if (!board.getWhitetomove() && //Check is it blacks turn
                takeCheck(move, board) && //Check is move take
                endsquare == -7){ //Check is end square en passant take allowing
            return true;
        }
        return false;
    }

    /**
     * Checks if move leads to promotion of pawn
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move would lead to promotion
     */
    public boolean promotionCheck(Move move, Board board){
        //Check if move would lead to 8th row on the board for white
        if (board.getWhitetomove() && //Check is it whites turn
                move.getMove()[3] == 0){ //Check if move would lead to square that allows promotion
            return true;
        }
        //Check if move would lead to 1st row on the board for black
        else if (!board.getWhitetomove() && //Check is it blacks turn
                move.getMove()[3] == 7){ //Check if move would lead to square that allows promotion
            return true;
        }
        return false;
    }

    /**
     * Checks that given move is allowed for this piece
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is allowed
     */
    public boolean moveCheck(Move move, Board board){
        //Check all possible legal moves, no need to check special cases of each move
        if (takeCheck(move, board) || //Check is move take
                singleMoveCheck(move, board) || //Check is move single move forward
                doubleMoveCheck(move, board)){ //Check is move double move forward
            return true;
        }
        return false;
    }

    /**
     * Check if pawn can move one step forward
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if pawn can move 1 step forward and the square is empty
     */
    public boolean singleMoveCheck(Move move, Board board){
        //If white pawn tries to move one step forward in y-axis and the square is empty return true
        if (board.getWhitetomove() && //Check is it whites turn
                move.getMove()[1] - move.getMove()[3] == 1 && //Check that moves 1 step forward in y-axis
                move.getMove()[0] == move.getMove()[2] && //Check that x-axis doesn't change
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] == 0){ //Check that end square is empty
            return true;
        }
        //If black pawn tries to move one step forward in y-axis and the square is empty return true
        else if (!board.getWhitetomove() && //Check is it blacks turn
                move.getMove()[1] - move.getMove()[3] == -1 && //Check that moves 1 step forward in y-axis
                move.getMove()[0] == move.getMove()[2] && //Check that x-axis doesn't change
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] == 0){ //Check that end square is empty
            return true;
        }
        return false;
    }

    /**
     * Check if pawn is allowed to move 2 steps forward
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if pawn can move 2 steps forward and the square is empty
     */
    public boolean doubleMoveCheck(Move move, Board board){
        //Check is white pawn in 2nd row and not blocked to move 2 steps forward
        if (board.getWhitetomove() && //Check is it whites turn
                move.getMove()[1] - move.getMove()[3] == 2 && //Check that moves 2 steps forward in y-axis
                move.getMove()[0] == move.getMove()[2] && //Check that x-axis doesn't change
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] == 0 && //Check that end square is empty
                board.getBoard()[move.getMove()[3]+1][move.getMove()[2]] == 0 && //Check that square in middle of move is empty
                move.getMove()[1] == 6){ //Check that pawn is still in starting square
            return true;
        }
        //Check is black pawn in 7th row and not blocked to move 2 steps forward
        else if (!board.getWhitetomove() && //Check is it blacks turn
                move.getMove()[1] - move.getMove()[3] == -2 && //Check that moves 2 steps forward in y-axis
                move.getMove()[0] == move.getMove()[2] && //Check that x-axis doesn't change
                board.getBoard()[move.getMove()[3]][move.getMove()[2]] == 0 && //Check that end square is empty
                board.getBoard()[move.getMove()[3]-1][move.getMove()[2]] == 0 && //Check that square in middle of move is empty
                move.getMove()[1] == 1){ //Check that pawn is still in starting square
            return true;
        }
        return false;
    }

    /**
     * Check if move is a take of enemy piece
     * @param move move to check
     * @param board current game state
     * @return True if pawn can take enemy piece on left or right side
     */
    public boolean takeCheck(Move move, Board board){
        int endsquare = board.getBoard()[move.getMove()[3]][move.getMove()[2]];
        //Check is there a black piece that is one step forward and either left or right side of white pawn
        if (board.getWhitetomove() && //Check is it whites turn
                move.getMove()[1] - move.getMove()[3] == 1 && //Check is move 1 step forward in y-axis
                math.abs(move.getMove()[0] - move.getMove()[2]) == 1 && //Check is move 1 step to left or right
                endsquare >= 1) { //Check is end square black piece
            return true;
        }
        //Check is there a white piece that is one step forward and either left or right side of black pawn
        else if (!board.getWhitetomove() && //Check is it blacks turn
                move.getMove()[1] - move.getMove()[3] == -1 && //Check is move 1 step forward in y-axis
                math.abs(move.getMove()[0] - move.getMove()[2]) == 1 && //Check is move 1 step to left or right
                endsquare <= -1){ //Check is end square white piece
            return true;
        }
        return false;
    }
}
