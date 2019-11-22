package chess.move.rules;

import chess.Board;
import chess.move.Move;
import chess.structures.MathFunctions;

public class BishopRules {
    MathFunctions math = new MathFunctions();

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
        //Check that start square is white bishop and end square is empty or black piece
        if (board.getWhitetomove() && //Check is it whites turn
                startsquare == -4 && //Check does start square contain white bishop
                endsquare >= 0){ //Check is end square empty or black piece
            return moveCheck(move, board);
        }
        //Check that start square is black bishop and end square is empty or white piece
        else if (!board.getWhitetomove() && //Check is it blacks turn
                startsquare == 4 && //Check does start square contain black bishop
                endsquare <= 0){ //Check is end square empty or white piece
            return moveCheck(move, board);
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
        int x = math.abs(move.getMove()[0] - move.getMove()[2]); //Store absolute value of subtraction of start square x and end square x
        int y = math.abs(move.getMove()[1] - move.getMove()[3]); //Store absolute value of subtraction of start square y and end square y
        //If piece is not moving diagonal it is valid move and return false
        if (x != y) return false;
        //If no piece is blocking return true
        if (noPieceIsBlocking(move, board)){
            return true;
        }
        return false;
    }

    /**
     * Checks that all the squares between start and end are empty.
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if nothing is blocking this piece to move to end square
     */
    public boolean noPieceIsBlocking(Move move, Board board){
        int x1 = move.getMove()[0]; //Store start square x value
        int y1 = move.getMove()[1]; //Store start square y value
        int x2 = move.getMove()[2]; //Store end square x value
        int y2 = move.getMove()[3]; //Store end square y value

        /* Below we check that in any of the 4 different directions the bishop can move
        nothing is blocking it. We have to do this in 4 different cases.
        */
        //Case 1: Bishop moves to down and right
        if (x1 < x2 && y1 < y2){
            for (int i = 1; i < x2-x1; i++){
                if (board.getBoard()[y1+i][x1+i] != 0) return false; //if square no empty return false
            }
        }
        //Case 2: Bishop moves to up and right
        else if (x1 < x2 && y1 > y2){
            for (int i = 1; i < x2-x1; i++){
                if (board.getBoard()[y1-i][x1+i] != 0) return false; //if square no empty return false
            }
        }
        //Case 3: Bishop moves to down and left
        else if (x1 > x2 && y1 < y2){
            for (int i = 1; i < x1-x2; i++){
                if (board.getBoard()[y1+i][x1-i] != 0) return false; //if square no empty return false
            }
        }
        //Case 4: Bishop moves to up and left
        else {
            for (int i = 1; i < x1-x2; i++){
                if (board.getBoard()[y1-i][x1-i] != 0) return false; //if square no empty return false
            }
        }
        return true;
    }
}
