package chess;

public class MoveValidator {

    public Boolean isMoveValid(int[] move, Board board){
        int[][] gameboard = board.getBoard();
        if (board.getWhitetomove() && gameboard[move[1]][move[0]] < 0 && gameboard[move[3]][move[2]] >= 0){
            if (gameboard[move[1]][move[0]] == -1) return whitePawnMoveCheck(move, board);
        }
        else if (!board.getWhitetomove() && gameboard[move[1]][move[0]] > 0 && gameboard[move[3]][move[2]] <= 0){
            if (gameboard[move[1]][move[0]] == 1) return blackPawnMoveCheck(move, board);
        }
        return false;
    }

    /**
     *
     * @param move array which contains move coordinates
     * @param board game board/state
     * @return if pawn is allowed to make the given move
     */
    public boolean whitePawnMoveCheck(int[] move, Board board){
        // Checks if pawn moving 1 square forward is valid
        if (move[1] - move[3] == 1 && move[0] == move[2] && board.getBoard()[move[3]][move[2]] == 0) return true;
        // Checks if pawn moving 2 squares forward is valid. This requires the pawn to be at starting location.
        if (move[1] - move[3] == 2 && move[0] == move[2] && board.getBoard()[move[3]][move[2]] == 0 &&
                board.getBoard()[move[3]-1][move[2]] == 0 && move[1] == 6) return true;
        // Check if pawn can eat black piece
        if (move[1] - move[3] == 1 && (move[0] - move[2] == 1 || move[0] - move[2] == -1) &&
                board.getBoard()[move[3]][move[2]] >= 1) return true;
        return false;
    }

    /**
     *
     * @param move array which contains move coordinates
     * @param board game board/state
     * @return if pawn is allowed to make the given move
     */
    public boolean blackPawnMoveCheck(int[] move, Board board){
        // Checks if pawn moving 1 square forward is valid
        if (move[1] - move[3] == -1 && move[0] == move[2] && board.getBoard()[move[3]][move[2]] == 0) return true;
        // Checks if pawn moving 2 squares forward is valid. This requires the pawn to be at starting location.
        if (move[1] - move[3] == -2 && move[0] == move[2] && board.getBoard()[move[3]][move[2]] == 0 &&
                board.getBoard()[move[3]+1][move[2]] == 0 && move[1] == 1) return true;
        // Check if pawn can eat white piece
        if (move[1] - move[3] == -1 && (move[0] - move[2] == 1 || move[0] - move[2] == -1) &&
                board.getBoard()[move[3]][move[2]] <= 1) return true;
        return false;
    }
}
