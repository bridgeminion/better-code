package google_high_frequency;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n*n+1];
        queue.offer(1);
        visited[1] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int pos = queue.poll();
                if (pos == n*n) {
                    return steps;
                }
                for (int next=pos+1; next<=Math.min(pos+6, n*n); next++) {
                    int[] location = posToLocation(next, n);
                    int nextPos = next;
                    if (board[location[0]][location[1]] != -1) {
                        nextPos = board[location[0]][location[1]];                                 }
                    if (!visited[nextPos]) {
                        queue.offer(nextPos);
                        visited[nextPos] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private int[] posToLocation(int pos, int n) {
        int row = (pos-1)/n, col = (pos-1)%n;
        int x = n - row - 1;
        int y = row%2 == 0 ? col : n-1-col;
        return new int[] {x, y};
    }

    public static void main(String[] args) {
        SnakesAndLadders app = new SnakesAndLadders();
        int[][] board = {{-1,-1,19,10,-1},{2,-1,-1,6,-1},{-1,17,-1,19,-1},{25,-1,20,-1,-1},{-1,-1,-1,-1,15}};
        System.out.println(app.snakesAndLadders(board));
    }

}
