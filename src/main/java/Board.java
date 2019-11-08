public class Board {

    public int[][] board;


    public Board(){
        this.board = new int[8][8];
        this.board[0][0] = 2;
        this.board[0][1] = 3;
        this.board[0][2] = 4;
        this.board[0][3] = 5;
        this.board[0][4] = 6;
        this.board[0][5] = 4;
        this.board[0][6] = 3;
        this.board[0][7] = 2;
        this.board[7][0] = -2;
        this.board[7][1] = -3;
        this.board[7][2] = -4;
        this.board[7][3] = -5;
        this.board[7][4] = -6;
        this.board[7][5] = -4;
        this.board[7][6] = -3;
        this.board[7][7] = -2;

        for (int i=0; i < 8; i++){
            this.board[1][i] = 1;
            this.board[6][i] = -1;
        }
    }


    public Board(int[][] board){
        this.board = board;
    }


    public boolean move(String move){


        return false;
    }
}
