package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Contest5882 {
    class Entry {
        int x;
        int y;
        int sum;
        public Entry(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
    public long gridGame1(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        PriorityQueue<Entry> queue = new PriorityQueue<>((e1, e2) -> e2.sum - e1.sum);
        int robot1 = 0;
        queue.offer(new Entry(0, 0, grid[0][0]));
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Entry entry = queue.poll();
            if (entry.x == r-1 && entry.y == c-1) {
                robot1 = entry.sum;
                break;
            }
            if (entry.x < r-1) {
                int nextX = entry.x + 1;
                int nextY = entry.y;
                if (!visited[nextX][nextY]) {
                    queue.offer(new Entry(nextX, nextY, entry.sum + grid[nextX][nextY]));
                    visited[nextX][nextY] = true;
                }
            }
            if (entry.y < c-1) {
                int nextX = entry.x;
                int nextY = entry.y + 1;
                if (!visited[nextX][nextY]) {
                    queue.offer(new Entry(nextX, nextY, entry.sum + grid[nextX][nextY]));
                    visited[nextX][nextY] = true;
                }
            }
        }
        return 0;
    }

    int max;
    List<int[]> path;
    public long gridGame2(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0,0});
        visited[0][0] = true;
        helper(grid, 0, 0, grid[0][0], r, c, visited, list);

        return 0;
    }

    private void helper(int[][] grid, int x, int y, int sum, int r, int c, boolean[][] visited, List<int[]> list) {
        if (x > r || y > c || visited[x][y]) {
            return;
        }
        if (x == r && y == c) {
            max = Math.max(max, sum);
            path = new ArrayList<>(list);
            return;
        }
        visited[x+1][y] = true;
        list.add(new int[] {x+1, y});
        helper(grid, x+1, y, sum + grid[x+1][y], r, c, visited, list);
        list.remove(list.size() - 1);
        visited[x+1][y] = false;
        visited[x][y+1] = true;
        list.add(new int[] {x, y+1});
        helper(grid, x, y+1, sum + grid[x][y+1], r, c, visited, list);
        list.remove(list.size() - 1);
        visited[x][y+1] = false;
    }

    public long gridGame(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        long[][] prefixSum = new long[r][c];
        for (int i=c-1; i>=0; i--) {
            if (i == c-1) {
                prefixSum[0][i] = grid[0][i];
            } else {
                prefixSum[0][i] = grid[0][i] + prefixSum[0][i+1];
            }
        }
        for (int i=0; i<c; i++) {
            if (i == 0) {
                prefixSum[1][i] = grid[1][i];
            } else {
                prefixSum[1][i] = grid[1][i] + prefixSum[1][i-1];
            }
        }
        long min = Long.MAX_VALUE;
        long max;
        for (int i=0; i<c; i++) {
            if (i == 0) {
                max = prefixSum[0][1];
            } else if (i+1 == c) {
                max = prefixSum[1][i-1];
            } else {
                max = Math.max(prefixSum[1][i-1], prefixSum[0][i+1]);
            }
            min = Math.min(min, max);
        }

        return min;
    }

    public static void main(String[] args) {
        Contest5882 instance = new Contest5882();
        int[][] grid = {{3,3,1},{8,5,2}};
        System.out.println(instance.gridGame(grid));
    }
}
