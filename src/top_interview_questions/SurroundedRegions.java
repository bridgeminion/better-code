package top_interview_questions;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j, r, c);
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int r, int c) {
        board[i][j] = '*';
        int[][] moves = {{1,0}, {-1,0}, {0,1},  {0,-1}};
        for (int[] move : moves) {
            int newRow = i + move[0];
            int newCol = j + move[1];
            if (newRow >=0 && newRow < r && newCol >= 0 && newCol < c && board[newRow][newCol] == 'O') {
                dfs(board, newRow, newCol, r, c);
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions instance = new SurroundedRegions();
        char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        instance.solve(board);

    }

}
