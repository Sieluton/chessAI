package chess.move.rules;

import chess.Board;
import chess.move.Move;

public class RookRules {

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
        //Check that start square is white rook and end square is empty or black piece
        if (board.getWhitetomove() && //Check is it whites turn
                startsquare == -2 && //Check does start square contain white rook
                endsquare >= 0){ //Check that end square is empty or black piece
            return moveCheck(move, board);
        }
        //Check that start square is black rook and end square is empty or white piece
        else if (!board.getWhitetomove() && //Check is it blacks turn
                startsquare == 2 && //Check does start square contain black rook
                endsquare <= 0){ //Check that end square is empty or white piece
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
        //If not moving on 1-axis only then false
        if (move.getMove()[0] != move.getMove()[2] && //Check is movement happening in x-axis
                move.getMove()[1] != move.getMove()[3]){ //Check is movement happening in y-axis
            return false;
        }
        if (noPieceIsBlocking(move, board)){ //If no piece is blocking return true
            return true;
        }
        return false;
    }

    /**
     * Checks that all the squares between start square and end square are empty.
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if nothing is blocking this piece to move to end square
     */
    public boolean noPieceIsBlocking(Move move, Board board){
        int i, j; //i is smaller of the start and end squares
        boolean axis; //Value true means x-axis and false y-axis
        //If movement is in y-axis change i and j accordingly so i < j
        if (move.getMove()[1] < move.getMove()[3]){ //Check is start square y < end square y
            i = move.getMove()[1]; //i = start square y
            j = move.getMove()[3]; //j = end square y
            axis = false; //Used axis is now y-axis
        }
        //If movement is in y-axis change i and j accordingly so i < j
        else if (move.getMove()[1] > move.getMove()[3]){ //Check is start square y > end square y
            i = move.getMove()[3]; //i = end square y
            j = move.getMove()[1]; //j = start square y
            axis = false; //Used axis is now y-axis
        }
        //If movement is in x-axis change i and j accordingly so i < j
        else if (move.getMove()[0] < move.getMove()[2]){ //Check is start square x < end square x
            i = move.getMove()[0]; //i = start square x
            j = move.getMove()[2]; //j = end square x
            axis = true; //Used axis is now x-axis
        }
        //Movement is in x-axis change i and j accordingly so i < j
        else { //Start square x is > end square x
            i = move.getMove()[2]; //i = end square x
            j = move.getMove()[0]; //j = start square x
            axis = true; //Used axis is now x-axis
        }
        for (i++; i < j; i++){ //Loop over all squares the rook moves over and check if they are empty
            if (axis && board.getBoard()[move.getMove()[1]][i] != 0) return false; //Movement happens in x-axis
            else if (!axis && board.getBoard()[i][move.getMove()[0]] != 0) return false; //Movement happens in y-axis
        }
        return true;
    }
}
