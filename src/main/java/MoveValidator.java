public class MoveValidator {

    public boolean pawnMove(int[][] board, String move){
        int startY = move.charAt(0);
        int startX = move.charAt(1);
        int endY = move.charAt(2);
        int endX = move.charAt(3);

        if (board[startY][startX] == 1){

        } else{

        }

        return false;
    }
}
