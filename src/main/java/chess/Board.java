package chess;

public class Board {

    public int[][] board;
    public boolean whitetomove;
    public int enpassant = 0;
    public boolean whitekingmoved = false;
    public boolean whiteleftrookmoved = false;
    public boolean whiterightrookmoved = false;
    public boolean blackkingmoved = false;
    public boolean blackleftrookmoved = false;
    public boolean blackrightrookmoved = false;

    /**
     * Constructor for normal game
     */
    public Board() {
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

        for (int i = 0; i < 8; i++) {
            this.board[1][i] = 1;
            this.board[6][i] = -1;
        }
        this.whitetomove = true;
    }

    /**
     * Constructor for game with board
     * @param board array[][]
     * @param whitenext boolean
     */
    public Board(int[][] board, boolean whitenext) {
        this.board = board;
        this.whitetomove = whitenext;
    }

    /**
     * Board getter
     * @return array[][]
     */
    public int[][] getBoard() {
        return this.board;
    }

    /**
     * Board setter
     * @param board array[][]
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * Whites turn getter
     * @return
     */
    public boolean getWhitetomove() {
        return this.whitetomove;
    }

    /**
     * Whites turn setter
     * @param whitetomove boolean
     */
    public void setWhitetomove(boolean whitetomove) {
        this.whitetomove = whitetomove;
    }

    /**
     * En passant value getter
     * @return int
     */
    public int getEnpassant() {
        return enpassant;
    }

    /**
     * En passant value setter
     * @param enpassant int
     */
    public void setEnpassant(int enpassant) {
        this.enpassant = enpassant;
    }

    /**
     * Getter for whitekingmoved
     * @return True if moved
     */
    public boolean isWhitekingmoved() {
        return whitekingmoved;
    }

    /**
     * Setter for whitekingmoved
     * @param whitekingmoved boolean
     */
    public void setWhitekingmoved(boolean whitekingmoved) {
        this.whitekingmoved = whitekingmoved;
    }

    /**
     * Getter for whiteleftrookmoved
     * @return True if moved
     */
    public boolean isWhiteleftrookmoved() {
        return whiteleftrookmoved;
    }

    /**
     * Setter for whiteleftrookmoved
     * @param whiteleftrookmoved boolean
     */
    public void setWhiteleftrookmoved(boolean whiteleftrookmoved) {
        this.whiteleftrookmoved = whiteleftrookmoved;
    }

    /**
     * Getter for whiterightrookmoved
     * @return True if moved
     */
    public boolean isWhiterightrookmoved() {
        return whiterightrookmoved;
    }

    /**
     * Setter for whiterightrookmoved
     * @param whiterightrookmoved boolean
     */
    public void setWhiterightrookmoved(boolean whiterightrookmoved) {
        this.whiterightrookmoved = whiterightrookmoved;
    }

    /**
     * Getter for blackkingmoved
     * @return True if moved
     */
    public boolean isBlackkingmoved() {
        return blackkingmoved;
    }

    /**
     * Setter for blackkingmoved
     * @param blackkingmoved boolean
     */
    public void setBlackkingmoved(boolean blackkingmoved) {
        this.blackkingmoved = blackkingmoved;
    }

    /**
     * Getter for blackleftrookmoved
     * @return True if moved
     */
    public boolean isBlackleftrookmoved() {
        return blackleftrookmoved;
    }

    /**
     * Setter for blackleftrookmoved
     * @param blackleftrookmoved boolean
     */
    public void setBlackleftrookmoved(boolean blackleftrookmoved) {
        this.blackleftrookmoved = blackleftrookmoved;
    }

    /**
     * Getter for blackrightrookmoved
     * @return True if moved
     */
    public boolean isBlackrightrookmoved() {
        return blackrightrookmoved;
    }

    /**
     * Setter for blackrightrookmoved
     * @param blackrightrookmoved boolean
     */
    public void setBlackrightrookmoved(boolean blackrightrookmoved) {
        this.blackrightrookmoved = blackrightrookmoved;
    }

    /**
     * To print out the board in a nice looking way.
     * Capital letters are black pieces and non-capital letters are white pieces
     * @return Boards as a string
     */
    public String toString() {
        String boardstring = "   A  B  C  D  E  F  G  H";
        for (int i = 0; i < this.board.length; i++) {
            boardstring += "\n" + (8 - i) + "|";
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[i][j] == 0) {
                    boardstring += " 0 ";
                }
                if (this.board[i][j] == 1) {
                    boardstring += " P ";
                }
                if (this.board[i][j] == 2) {
                    boardstring += " R ";
                }
                if (this.board[i][j] == 3) {
                    boardstring += " N ";
                }
                if (this.board[i][j] == 4) {
                    boardstring += " B ";
                }
                if (this.board[i][j] == 5) {
                    boardstring += " Q ";
                }
                if (this.board[i][j] == 6) {
                    boardstring += " K ";
                }
                if (this.board[i][j] == -1) {
                    boardstring += " p ";
                }
                if (this.board[i][j] == -2) {
                    boardstring += " r ";
                }
                if (this.board[i][j] == -3) {
                    boardstring += " n ";
                }
                if (this.board[i][j] == -4) {
                    boardstring += " b ";
                }
                if (this.board[i][j] == -5) {
                    boardstring += " q ";
                }
                if (this.board[i][j] == -6) {
                    boardstring += " k ";
                }
            }
        }
        return boardstring;
    }

    /**
     * Removes moving players en passant marks from the board when called.
     * This should be called at the start of every turn to keep en passant working correctly
     */
    public void removeEnPassant() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //If whites turn then remove his en passant shadow values
                if (board[i][j] == -7 && //Check does square contain whites en passant shadow value
                        whitetomove) { //Check is it whites turn
                    board[i][j] = 0; //Empty this square
                    enpassant--; //Keeps en passant counter correct
                }
                //If blacks turn then remove his en passant shadow values
                else if (board[i][j] == 7 && //Check does square contain blacks en passant shadow value
                        !whitetomove) { //Check is it blacks turn
                    board[i][j] = 0; //Empty this square
                    enpassant--; //Keeps en passant counter correct
                }
            }
        }
    }

    /**
     * Change which players turn it is
     */
    public void changeTurn() {
        this.whitetomove = !this.whitetomove;
    }
}
