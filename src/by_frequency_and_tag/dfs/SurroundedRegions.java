package by_frequency_and_tag.dfs;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i=0; i<m; i++) {
            if (board[i][0] == 'O') {
                floodfill(board, i, 0, m, n);
            }
            if (board[i][n-1] == 'O') {
                floodfill(board, i, n-1, m, n);
            }
        }
        for (int i=0; i<n; i++) {
            if (board[0][i] == 'O') {
                floodfill(board, 0, i, m, n);
            }
            if (board[m-1][i] == 'O') {
                floodfill(board, m-1, i, m, n);
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    private void floodfill(char[][] board, int i, int j, int m, int n) {
        if (i<0 || i>=m || j<0 || j>=n || board[i][j] != 'O') {
            return;
        }
        board[i][j]= '*';
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] dir : dirs) {
            floodfill(board, i+dir[0], j+dir[1], m, n);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','O','X'},{'O','X','O'},{'X','O','X'}};
        SurroundedRegions app = new SurroundedRegions();
        app.solve(board);
    }
}
