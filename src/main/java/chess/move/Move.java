package chess.move;

import chess.Board;
import chess.move.MoveValidator;
import chess.move.pieces.PawnMoves;
import chess.move.rules.PawnRules;

import java.util.Scanner;

/**
 *
 */
public class Move {
    public MoveValidator validator = new MoveValidator();
    public int[] move;
    public int promoteTo;
    public PawnRules pawnrules = new PawnRules();
    public PawnMoves pawnmoves = new PawnMoves();

    public Move(){
        move = new int[4];
        promoteTo = 5;
    }

    public Move(int[] move){
        this.move = move;
    }

    /**
     * Given a move does it if it is valid.
     * @param playerMove move as String
     * @return True if the move was made
     */
    public Boolean playerMove(String playerMove, Board board){
        parseMove(playerMove);
        // remove enpassant, might move later
        board.removeEnPassant();
        if (validator.isPawnMove(this, board)){
            if (pawnrules.enPassantCheck(this, board)) pawnmoves.enPassant(this, board);
            else if (pawnrules.doubleMoveCheck(this, board)) pawnmoves.doubleMove(this, board);
            else if (pawnrules.promotionCheck(this, board)){
                //promotionGet();
                pawnmoves.promotion(this, board);
            }
            else pawnmoves.move(this, board);
            board.setWhitetomove(!board.getWhitetomove());
            return true;
        }
        return false;
    }

    /**
     * Parses the move and returns it.
     * @param playerMove move as string
     * @return Parsed move as array
     */
    public Boolean parseMove(String playerMove){
        if (playerMove.length() > 4) return false;
        int[] move = new int[4];
        for (int i = 0; i < move.length; i++){
            if (playerMove.charAt(i) == 'a' || playerMove.charAt(i) == '1' || playerMove.charAt(i) == 'A') move[i] = 0;
            if (playerMove.charAt(i) == 'b' || playerMove.charAt(i) == '2' || playerMove.charAt(i) == 'B') move[i] = 1;
            if (playerMove.charAt(i) == 'c' || playerMove.charAt(i) == '3' || playerMove.charAt(i) == 'C') move[i] = 2;
            if (playerMove.charAt(i) == 'd' || playerMove.charAt(i) == '4' || playerMove.charAt(i) == 'D') move[i] = 3;
            if (playerMove.charAt(i) == 'e' || playerMove.charAt(i) == '5' || playerMove.charAt(i) == 'E') move[i] = 4;
            if (playerMove.charAt(i) == 'f' || playerMove.charAt(i) == '6' || playerMove.charAt(i) == 'F') move[i] = 5;
            if (playerMove.charAt(i) == 'g' || playerMove.charAt(i) == '7' || playerMove.charAt(i) == 'G') move[i] = 6;
            if (playerMove.charAt(i) == 'h' || playerMove.charAt(i) == '8' || playerMove.charAt(i) == 'H') move[i] = 7;
        }
        move[1] = 7 - move[1];
        move[3] = 7 - move[3];
        this.move = move;
        return true;
    }

    public int[] getMove(){
        return move;
    }

    public void setMove(int[] move){
        this.move = move;
    }

    public int getPromoteTo(){
        return promoteTo;
    }

    public void setPromoteTo(int i){
        this.promoteTo = i;
    }

    public void promotionGet(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("This move leads to promotion. Specify with following numbers: Rook = 1, Knight = 2, Bishop = 3, Queen = 4");
        int i = scanner.nextInt();
        if (i == 1) promoteTo = 2;
        else if (i == 2) promoteTo = 3;
        else if (i == 3) promoteTo = 4;
        else promoteTo = 5;
    }

}
