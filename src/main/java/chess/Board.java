package chess;

public class Board {

    public int[][] board;
    public boolean whitetomove;
    public int enpassant = 0;

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
        this.whitetomove = true;
    }

    public Board(int[][] board, boolean whitenext){
        this.board = board;
        this.whitetomove = whitenext;
    }

    public int[][] getBoard(){
        return this.board;
    }

    public void setBoard(int[][] board){
        this.board = board;
    }

    public boolean getWhitetomove(){
        return this.whitetomove;
    }

    public void setWhitetomove(boolean whitetomove){
        this.whitetomove = whitetomove;
    }

    public int getEnpassant(){
        return enpassant;
    }

    public void setEnpassant(int enpassant){
        this.enpassant = enpassant;
    }

    public String toString(){
        String boardstring = "   A  B  C  D  E  F  G  H";
        for (int i = 0; i < this.board.length; i++){
            boardstring += "\n" + (8-i) + "|";
            for (int j = 0; j < this.board.length; j++){
                if (this.board[i][j] == 0) boardstring += " 0 ";
                if (this.board[i][j] == 1) boardstring += " P ";
                if (this.board[i][j] == 2) boardstring += " R ";
                if (this.board[i][j] == 3) boardstring += " N ";
                if (this.board[i][j] == 4) boardstring += " B ";
                if (this.board[i][j] == 5) boardstring += " Q ";
                if (this.board[i][j] == 6) boardstring += " K ";
                if (this.board[i][j] == -1) boardstring += " p ";
                if (this.board[i][j] == -2) boardstring += " r ";
                if (this.board[i][j] == -3) boardstring += " n ";
                if (this.board[i][j] == -4) boardstring += " b ";
                if (this.board[i][j] == -5) boardstring += " q ";
                if (this.board[i][j] == -6) boardstring += " k ";
                //en passant testing
                if (this.board[i][j] == 7) boardstring += " + ";
                if (this.board[i][j] == -7) boardstring += " - ";
            }
        }
        return boardstring;
    }

    /**
     * Removes moving players en passant marks from the board when called.
     * This should happen at the start of every move as by the rules.
     */
    public void removeEnPassant(){
        //if (enpassant == 0) return;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == -7 && whitetomove){
                    board[i][j] = 0;
                    enpassant--;
                }
                else if (board[i][j] == 7 && !whitetomove){
                    board[i][j] = 0;
                    enpassant--;
                }
            }
        }
    }
}
