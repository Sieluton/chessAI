package chess.move.pieces;

import chess.Board;
import chess.move.Move;
import chess.move.rules.RookRules;

public class RookMoves {
    public RookRules rookrules = new RookRules();

    public void makeMove(Move move, Board board){
        if (rookrules.moveCheck(move, board)){
            move(move, board);
        }
        board.setWhitetomove(!board.getWhitetomove());
    }

    public void move(Move move, Board board){
        int[][] game = board.getBoard();
        game[move.getMove()[3]][move.getMove()[2]] = game[move.getMove()[1]][move.getMove()[0]];
        game[move.getMove()[1]][move.getMove()[0]] = 0;
        board.setBoard(game);
    }
}
