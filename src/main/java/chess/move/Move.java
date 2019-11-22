package chess.move;

import chess.Board;
import chess.move.MoveValidator;
import chess.move.pieces.*;

import java.util.Scanner;

/**
 * Handles the parsing of moves and passing them to correct methods
 */
public class Move {
    public MoveValidator validator = new MoveValidator();
    public int[] move;
    public int promoteTo;
    public PawnMoves pawnmoves = new PawnMoves();
    public RookMoves rookmoves = new RookMoves();
    public KnightMoves knightmoves = new KnightMoves();
    public BishopMoves bishopmoves = new BishopMoves();
    public QueenMoves queenmoves = new QueenMoves();
    public KingMoves kingmoves = new KingMoves();

    public Move(){
        move = new int[4];
        promoteTo = 5;
    }

    public Move(int[] move){
        this.move = move;
    }

    /**
     * Given a move passes it to right method to handle.
     * @param playerMove move as String
     * @return True if the move was made
     */
    public boolean playerMove(String playerMove, Board board){
        //Check that player gives move that wont crash
        if (!parseMove(playerMove)) return false;
        else parseMove(playerMove);
        //If board contains en passant shadow value from last round remove it
        if (board.getEnpassant() > 0) board.removeEnPassant();
        //If move is pawn move let pawn mover class handle it
        if (validator.isPawnMove(this, board)){
            pawnmoves.makeMove(this, board);
            return true;
        }
        //If move is rook move let rook mover class handle it
        else if (validator.isRookMove(this, board)){
            rookmoves.makeMove(this, board);
            return true;
        }
        //If move is knight move let knight mover class handle it
        else if (validator.isKnightMove(this, board)){
            knightmoves.makeMove(this, board);
            return true;
        }
        //If move is bishop move let bishop mover class handle it
        else if (validator.isBishopMove(this, board)){
            bishopmoves.makeMove(this, board);
            return true;
        }
        //If move is queen move let queen mover class handle it
        else if (validator.isQueenMove(this, board)){
            queenmoves.makeMove(this, board);
            return true;
        }
        //If move is king move let king mover class handle it
        else if (validator.isKingMove(this, board)){
            kingmoves.makeMove(this, board);
            return true;
        }
        return false;
    }

    /**
     * Parses the move and returns it.
     * @param playerMove move as string
     * @return Parsed move as array
     */
    public boolean parseMove(String playerMove){
        //Checks if move is < 4 since it would crash
        if (playerMove.length() < 4) return false;
        int[] move = new int[4];
        for (int i = 0; i < 4; i++){
            if (playerMove.charAt(i) == 'a' || playerMove.charAt(i) == '1' || playerMove.charAt(i) == 'A') move[i] = 0;
            if (playerMove.charAt(i) == 'b' || playerMove.charAt(i) == '2' || playerMove.charAt(i) == 'B') move[i] = 1;
            if (playerMove.charAt(i) == 'c' || playerMove.charAt(i) == '3' || playerMove.charAt(i) == 'C') move[i] = 2;
            if (playerMove.charAt(i) == 'd' || playerMove.charAt(i) == '4' || playerMove.charAt(i) == 'D') move[i] = 3;
            if (playerMove.charAt(i) == 'e' || playerMove.charAt(i) == '5' || playerMove.charAt(i) == 'E') move[i] = 4;
            if (playerMove.charAt(i) == 'f' || playerMove.charAt(i) == '6' || playerMove.charAt(i) == 'F') move[i] = 5;
            if (playerMove.charAt(i) == 'g' || playerMove.charAt(i) == '7' || playerMove.charAt(i) == 'G') move[i] = 6;
            if (playerMove.charAt(i) == 'h' || playerMove.charAt(i) == '8' || playerMove.charAt(i) == 'H') move[i] = 7;
        }
        move[1] = 7 - move[1]; //Change y-axis of player input to match boards y-axis values
        move[3] = 7 - move[3]; //Change y-axis of player input to match boards y-axis values
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

    //May get removed later on
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
