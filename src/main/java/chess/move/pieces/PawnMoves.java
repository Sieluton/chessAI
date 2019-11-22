package chess.move.pieces;

import chess.Board;
import chess.move.Move;
import chess.move.rules.PawnRules;

public class PawnMoves {
    public PawnRules pawnrules = new PawnRules();

    /**
     * Used to make move on given piece
     * @param move Move object contains move
     * @param board Board object that stores game state
     */
    public void makeMove(Move move, Board board){
        if (pawnrules.enPassantCheck(move, board)) enPassant(move, board); //If move is en passant calls en passant method to make it
        else if (pawnrules.doubleMoveCheck(move, board)) doubleMove(move, board); //If move is double move take calls double move method to make it
        else if (pawnrules.promotionCheck(move, board)) promotion(move, board); //If move is promotion calls promotion method to do it
        else move(move, board); //Calls move method to do the move
        board.changeTurn(); //Change turn
    }

    /**
     * Handle en passant take
     * @param move Move object contains move
     * @param board Board object that stores game state
     */
    public void enPassant(Move move, Board board){
        int[][] game = board.getBoard(); //Store chessboard to edit
        //Make en passant take for white
        if (board.getWhitetomove()) { //Check is it whites turn
            game[move.getMove()[1]][move.getMove()[0]] = 0; //Empty start square
            game[move.getMove()[3]][move.getMove()[2]] = -1; //Set end square value to white pawn
            game[move.getMove()[3]+1][move.getMove()[2]] = 0; //Remove black pawn
        }
        //Make en passant take for black
        else {
            game[move.getMove()[1]][move.getMove()[0]] = 0; //Empty start square
            game[move.getMove()[3]][move.getMove()[2]] = 1; //Set end square value to black pawn
            game[move.getMove()[3]-1][move.getMove()[2]] = 0; //Remove white pawn
        }
        board.setBoard(game); //Make edited chessboard to current chessboard
        board.setEnpassant(board.getEnpassant() - 1); //Amount of en passant shadow values is decreased by one
    }

    /**
     * Make promotion for pawn
     * @param move Move object contains move
     * @param board Board object that stores game state
     */
    public void promotion(Move move, Board board){
        int[][] game = board.getBoard(); //Store chessboard to edit
        //Make promotion for white pawn
        if (board.getWhitetomove()) { //Check is it whites turn
            game[move.getMove()[1]][move.getMove()[0]] = 0; //Empty start square
            game[move.getMove()[3]][move.getMove()[2]] = 0 - move.getPromoteTo(); //Set end square to piece you want
        }

        else {
            game[move.getMove()[1]][move.getMove()[0]] = 0; //Empty start square
            game[move.getMove()[3]][move.getMove()[2]] = move.getPromoteTo(); //Set end square to piece you want
        }
        board.setBoard(game); //Make edited chessboard to current chessboard
    }

    /**
     * Given move copies value of start square to end square and empties start square
     * @param move Move object contains move
     * @param board Board object that stores game state
     */
    public void move(Move move, Board board){
        int[][] game = board.getBoard(); //Store chessboard to edit
        game[move.getMove()[3]][move.getMove()[2]] = game[move.getMove()[1]][move.getMove()[0]]; //Copy start square to end square
        game[move.getMove()[1]][move.getMove()[0]] = 0; //Empty start square
        board.setBoard(game); //Make edited chessboard to current chessboard
    }

    /**
     *
     * @param move Move object contains move
     * @param board Board object that stores game state
     */
    public void doubleMove(Move move, Board board){
        int[][] game = board.getBoard(); //Store chessboard to edit
        //Make double move for white pawn
        if (board.getWhitetomove()) { //Check is it whites turn
            game[move.getMove()[1]][move.getMove()[0]] = 0; //Empty start square
            game[move.getMove()[3]][move.getMove()[2]] = -1; //Set end square as white pawn
            game[move.getMove()[3]+1][move.getMove()[2]] = -7; //Set square in between start and end square as shadow value for black en passant
            board.setEnpassant(board.getEnpassant()+1); //Add one amount of en passant shadow values so it can be removed when it's legal move anymore
        }
        //Make double move for black pawn
        else {
            game[move.getMove()[1]][move.getMove()[0]] = 0; //Empty start square
            game[move.getMove()[3]][move.getMove()[2]] = 1; //Set end square as black pawn
            game[move.getMove()[3]-1][move.getMove()[2]] = 7; //Set square in between start and end square as shadow value for white en passant
            board.setEnpassant(board.getEnpassant()+1); //Add one amount of en passant shadow values so it can be removed when it's legal move anymore
        }
        board.setBoard(game); //Make edited chessboard to current chessboard
    }
}
