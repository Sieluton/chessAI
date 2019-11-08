package chess;

/**
 *
 */
public class Move {
    public MoveValidator validator = new MoveValidator();
    public int[] move;

    /**
     * Given a move does it if it is valid.
     * @param playerMove move as String
     * @return True if the move was made
     */
    public Boolean playerMakeMove(String playerMove, Board board){
        parseMove(playerMove);
        if (this.validator.isMoveValid(move, board)){
            int[][] gameboard = board.getBoard();
            gameboard[move[3]][move[2]] = gameboard[move[1]][move[0]];
            gameboard[move[1]][move[0]] = 0;
            board.setBoard(gameboard);
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

}
