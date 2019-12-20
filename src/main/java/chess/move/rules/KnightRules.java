package chess.move.rules;

import chess.Board;
import chess.move.Move;
import chess.structures.MathFunctions;

public class KnightRules {
    MathFunctions math = new MathFunctions();

    /**
     * If start square contains given piece and end square is empty or enemy
     * piece then proceed to check if move is valid and return that. Else false.
     * @param move Move object contains move
     * @param board Board object that stores game state
     * @return True if move is valid
     */
    public boolean isValidMove(Move move, Board board) {
        int startsquare = board.getBoard()[move.getMove()[1]][move.getMove()[0]];
        int endsquare = board.getBoard()[move.getMove()[3]][move.getMove()[2]];
        //Check that start square is white knight and end square is empty or black piece
        if (board.getWhitetomove() && //Check is it whites turn
                startsquare == -3 && //Check does start square contain white knight
                endsquare >= 0) { //Check is end square empty or black piece
            return moveCheck(move, board);
        }
        //Check that start square is black knight and end square is empty or white piece
        else if (!board.getWhitetomove() &&  //Check is it blacks turn
                startsquare == 3 && //Check does start square contain black knight
                endsquare <= 0) { //Check is end square empty or white piece
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
    public boolean moveCheck(Move move, Board board) {
        //If move is correct for knight return true
        if (moveCorrectAmount(move)) {
            return true;
        }
        return false;
    }

    /**
     * Check that move is legal. Legal move is 2 steps forward and 1 step to side.
     * @param move Move object contains move
     * @return True if move is legal
     */
    public boolean moveCorrectAmount(Move move) {
        int a = math.abs(move.getMove()[0] - move.getMove()[2]);
        int b = math.abs(move.getMove()[1] - move.getMove()[3]);
        //True if moves 2 steps in one axis and 1 step in other axis
        if ((a == 2 && b == 1) || (a == 1 && b == 2)) {
            return true;
        }
        return false;
    }
}
