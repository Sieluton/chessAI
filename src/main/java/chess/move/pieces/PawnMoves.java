package chess.move.pieces;

import chess.Board;
import chess.move.Move;
import chess.move.rules.PawnRules;

public class PawnMoves {
    public PawnRules pawnrules = new PawnRules();

    public void makeMove(Move move, Board board){
        if (pawnrules.enPassantCheck(move, board)) enPassant(move, board);
        else if (pawnrules.doubleMoveCheck(move, board)) doubleMove(move, board);
        else if (pawnrules.promotionCheck(move, board)){
            //promotionGet();
            promotion(move, board);
        }
        else move(move, board);
        board.setWhitetomove(!board.getWhitetomove());
    }

    public void enPassant(Move move, Board board){
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
    }


    public void promotion(Move move, Board board){
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
    }


    public void move(Move move, Board board){
        int[][] game = board.getBoard();
        game[move.getMove()[3]][move.getMove()[2]] = game[move.getMove()[1]][move.getMove()[0]];
        game[move.getMove()[1]][move.getMove()[0]] = 0;
        board.setBoard(game);
    }


    public void doubleMove(Move move, Board board){
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
    }
}
