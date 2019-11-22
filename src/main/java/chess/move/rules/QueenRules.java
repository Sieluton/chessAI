package chess.move.rules;

import chess.Board;
import chess.move.Move;

public class QueenRules {
    public RookRules rookrules = new RookRules();
    public BishopRules bishoprules = new BishopRules();

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
        //Check that start square is white queen and end square is empty or black piece
        if (board.getWhitetomove() && //Check is it whites turn
                startsquare == -5 && //Check does start square contain white queen
                endsquare >= 0){ //Check is end square empty or black piece
            return moveCheck(move, board);
        }
        //Check that start square is black queen and end square is empty or white piece
        else if (!board.getWhitetomove() && //Check is it blacks turn
                startsquare == 5 && //Check does start square contain black queen
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
        //Since queen move is either rook or bishop move we can use those here
        if (rookrules.moveCheck(move, board)) return true; //True if move is valid rook move
        else if (bishoprules.moveCheck(move, board)) return true; //True if move is valid bishop move
        return false;
    }
}
