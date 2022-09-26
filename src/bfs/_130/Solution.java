package bfs._130;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
/*
  Start from four edges and BFS to mark all 'O' to 'A'
 */
public class Solution {
    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        Queue<Pair> queue = new LinkedList<>();
        int row = board.length, col = board[0].length;
        for (int i=0; i<col; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new Pair(0, i));
            }
            if (board[row-1][i] == 'O') {
                queue.offer(new Pair(row-1, i));
            }
        }
        for (int i=0; i<row; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new Pair(i, 0));
            }
            if (board[i][col-1] == 'O') {
                queue.offer(new Pair(i, col-1));
            }
        }
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            board[pair.x][pair.y] = 'A';
            for (int i=0; i<4; i++) {
                int nextX = pair.x + dx[i];
                int nextY = pair.y + dy[i];
                if (nextX >=0 && nextX < row && nextY >= 0 && nextY < col && board[nextX][nextY] == 'O') {
                    queue.offer(new Pair(nextX, nextY));
                }
            }

        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        solution.solve(board);
    }

}
