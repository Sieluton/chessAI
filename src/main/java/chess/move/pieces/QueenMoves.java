package chess.move.pieces;

import chess.Board;
import chess.move.Move;

public class QueenMoves {

    /**
     * Used to make move on given piece
     * @param move Move object contains move
     * @param board Board object that stores game state
     */
    public void makeMove(Move move, Board board){
        move(move, board); //Call method that executes give move
        board.changeTurn(); //Change turn
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
}
