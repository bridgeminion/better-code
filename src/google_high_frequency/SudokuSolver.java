package google_high_frequency;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') {
                    for (char k='1'; k<='9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (helper(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char x) {
        for (int k=0; k<9; k++) {
            if (board[i][k] == x) {
                return false;
            }
        }
        for (int k=0; k<9; k++) {
            if (board[k][j] == x) {
                return false;
            }
        }
        for (int k=i/3*3; k<i/3*3+3; k++) {
            for (int m=j/3*3; m<j/3*3+3; m++) {
                if (board[k][m] == x) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SudokuSolver app = new SudokuSolver();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
        app.solveSudoku(board);
    }
}
