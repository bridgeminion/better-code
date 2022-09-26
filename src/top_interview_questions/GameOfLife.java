package top_interview_questions;

/**
 * introduce deadToLive/liveToDead to record previous state
 */
public class GameOfLife {
    int dead = 0, live = 1, deadToLive = 2, liveToDead = 3;

    public void gameOfLife(int[][] board) {
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int lives = getLives(board, i, j, r, c);
                if (board[i][j] == dead && lives == 3) {
                    board[i][j] = deadToLive;
                } else if (board[i][j] == live) {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = liveToDead;
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == liveToDead) {
                    board[i][j] = 0;
                } else if (board[i][j] == deadToLive) {
                    board[i][j] = 1;
                }
            }

        }

    }

    private int getLives(int[][] board, int i, int j, int r, int c) {
        int lives = 0;
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        for (int[] move : moves) {
            int i1 = i + move[0];
            int j1 = j + move[1];
            if (i1 >= 0 && i1 < r && j1 >= 0 && j1 < c) {
                if (board[i1][j1] == live || board[i1][j1] == liveToDead) {
                    lives++;
                }
            }
        }
        return lives;
    }

    public static void main(String[] args) {
        GameOfLife instance = new GameOfLife();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        instance.gameOfLife(board);
    }
}
