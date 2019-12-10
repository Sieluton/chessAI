package chess;

import chess.move.Move;
import chess.move.MoveGenerator;
import chess.move.rules.KingRules;

import java.util.ArrayDeque;
import java.util.Deque;

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
    public int[] whitekingpos = new int[2];
    public int[] blackkingpos = new int[2];
    public ArrayDeque<Move> queue;
    public int score = 0;
    public KingRules kingrules = new KingRules();

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
        this.blackkingpos[0] = 4;
        this.board[0][5] = 4;
        this.board[0][6] = 3;
        this.board[0][7] = 2;
        this.board[7][0] = -2;
        this.board[7][1] = -3;
        this.board[7][2] = -4;
        this.board[7][3] = -5;
        this.board[7][4] = -6;
        this.whitekingpos[0] = 4;
        this.whitekingpos[1] = 7;
        this.board[7][5] = -4;
        this.board[7][6] = -3;
        this.board[7][7] = -2;

        for (int i = 0; i < 8; i++) {
            this.board[1][i] = 1;
            this.board[6][i] = -1;
        }
        this.whitetomove = true;
        generateMoves();
    }

    /**
     * Constructor for game with board
     * @param board array[][]
     * @param whitenext boolean
     */
    public Board(int[][] board, boolean whitenext) {
        this.board = board;
        this.whitetomove = whitenext;
        if (board[7][4] != -6) {
            this.whitekingmoved = true;
        }
        if (board[0][4] != 6) {
            this.blackkingmoved = true;
        }
        if (board[7][7] != -2) {
            this.whiterightrookmoved = true;
        }
        if (board[7][0] != -2) {
            this.whiteleftrookmoved = true;
        }
        if (board[0][7] != 2) {
            this.blackrightrookmoved = true;
        }
        if (board[0][0] != 2) {
            this.blackleftrookmoved = true;
        }
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[y][x] == 7 || board[y][x] == -7) {
                    this.enpassant++;
                }
            }
        }
        this.findKingPos();
        this.generateMoves();
    }

    /**
     * Make copy of another Board object
     * @param board Board object that stores game state
     */
    public Board(Board board) {
        this.whitetomove = board.getWhitetomove();
        this.enpassant = board.getEnpassant();
        this.whitekingmoved = board.isWhitekingmoved();
        this.whiteleftrookmoved = board.isWhiteleftrookmoved();
        this.whiterightrookmoved = board.isWhiterightrookmoved();
        this.blackkingmoved = board.isBlackkingmoved();
        this.blackleftrookmoved = board.isBlackleftrookmoved();
        this.blackrightrookmoved = board.isBlackrightrookmoved();
        for (int i = 0; i < 2; i++) {
            this.whitekingpos[i] = board.whitekingpos[i];
            this.blackkingpos[i] = board.blackkingpos[i];
        }
        int[][] game = new int[8][8];
        int[][] copygame = board.getBoard();
        for (int y = 0; y < game.length; y++) {
            for (int x = 0; x < game.length; x++) {
                game[y][x] = copygame[y][x];
            }
        }
        this.board = game;
        this.queue = board.queue;
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
                if (this.board[i][j] == 1) {
                    boardstring += " P ";
                }
                else if (this.board[i][j] == 2) {
                    boardstring += " R ";
                }
                else if (this.board[i][j] == 3) {
                    boardstring += " N ";
                }
                else if (this.board[i][j] == 4) {
                    boardstring += " B ";
                }
                else if (this.board[i][j] == 5) {
                    boardstring += " Q ";
                }
                else if (this.board[i][j] == 6) {
                    boardstring += " K ";
                }
                else if (this.board[i][j] == -1) {
                    boardstring += " p ";
                }
                else if (this.board[i][j] == -2) {
                    boardstring += " r ";
                }
                else if (this.board[i][j] == -3) {
                    boardstring += " n ";
                }
                else if (this.board[i][j] == -4) {
                    boardstring += " b ";
                }
                else if (this.board[i][j] == -5) {
                    boardstring += " q ";
                }
                else if (this.board[i][j] == -6) {
                    boardstring += " k ";
                }
                else {
                    boardstring += " 0 ";
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
     * Uses movement generation to get all possible moves to a queue
     */
    public void generateMoves() {
        queue = new MoveGenerator().generateMoves(this);
    }

    /**
     * Checks is there any legal moves available
     * @return True if there is at least one move
     */
    public boolean isLegalMoves() {
        if (queue.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Checks has game ended
     * @return True if game has ended
     */
    public boolean hasGameEnded() {
        if (!isLegalMoves()){
            return true;
        }
        return false;
    }

    /**
     * Change which players turn it is
     */
    public void changeTurn() {
        this.whitetomove = !this.whitetomove;
    }

    /**
     * Used to find king positions
     */
    public void findKingPos() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[y][x] == 6) {
                    blackkingpos[0] = x;
                    blackkingpos[1] = y;
                }
                if (board[y][x] == -6) {
                    whitekingpos[0] = x;
                    whitekingpos[1] = y;
                }
            }
        }
    }

    /**
     * Getter for score
     * @return int score of the game. 0 if tie, 1000 if black won and -1000 if white won
     */
    public int getScore() {
        this.updateScore();
        return this.score;
    }

    /**
     * Updates score of the game
     */
    public void updateScore() {
        if (!this.hasGameEnded()) {
            return;
        }
        if (this.getWhitetomove()) {
            if (this.kingrules.isSquareUnderAttack(this, this.whitekingpos[0], this.whitekingpos[1])) {
                this.score = 1000;
            }
        }
        else {
            if (this.kingrules.isSquareUnderAttack(this, this.blackkingpos[0], this.blackkingpos[1])) {
                this.score = -1000;
            }
        }
    }
}
