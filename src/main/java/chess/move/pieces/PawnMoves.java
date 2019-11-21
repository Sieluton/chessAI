package chess.move.pieces;

import chess.Board;
import chess.move.Move;

public class PawnMoves {

    public Board enPassant(Move move, Board board){
        int[][] game = board.getBoard();
        if (board.getWhitetomove()) {
            game[move.getMove()[1]][move.getMove()[0]] = 0;
            game[move.getMove()[3]][move.getMove()[2]] = -1;
            game[move.getMove()[3]+1][move.getMove()[2]] = 0;
        }
        else {
            game[move.getMove()[1]][move.getMove()[0]] = 0;
            game[move.getMove()[3]][move.getMove()[2]] = 1;
            game[move.getMove()[3]-1][move.getMove()[2]] = 0;
        }
        board.setBoard(game);
        board.setEnpassant(board.getEnpassant() + 1);
        return board;
    }


    public Board promotion(Move move, Board board){
        int[][] game = board.getBoard();
        if (board.getWhitetomove()) {
            game[move.getMove()[1]][move.getMove()[0]] = 0;
            game[move.getMove()[3]][move.getMove()[2]] = 0 - move.getPromoteTo();
        }
        else {
            game[move.getMove()[1]][move.getMove()[0]] = 0;
            game[move.getMove()[3]][move.getMove()[2]] = move.getPromoteTo();
        }
        board.setBoard(game);
        return board;
    }


    public Board move(Move move, Board board){
        int[][] game = board.getBoard();
        if (board.getWhitetomove()) {
            game[move.getMove()[1]][move.getMove()[0]] = 0;
            game[move.getMove()[3]][move.getMove()[2]] = -1;
        }
        else {
            game[move.getMove()[1]][move.getMove()[0]] = 0;
            game[move.getMove()[3]][move.getMove()[2]] = 1;
        }
        board.setBoard(game);
        return board;
    }


    public Board doubleMove(Move move, Board board){
        int[][] game = board.getBoard();
        if (board.getWhitetomove()) {
            game[move.getMove()[1]][move.getMove()[0]] = 0;
            game[move.getMove()[3]][move.getMove()[2]] = -1;
            game[move.getMove()[3]+1][move.getMove()[2]] = -7;
        }
        else {
            game[move.getMove()[1]][move.getMove()[0]] = 0;
            game[move.getMove()[3]][move.getMove()[2]] = 1;
            game[move.getMove()[3]-1][move.getMove()[2]] = 7;
        }
        board.setBoard(game);
        return board;
    }
}
