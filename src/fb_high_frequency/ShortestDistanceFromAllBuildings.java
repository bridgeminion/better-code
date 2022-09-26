package fb_high_frequency;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] count = new int[m][n];
        int buildingCount = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    buildingCount++;
                    bfs(grid, i, j, m, n, distance, count, new boolean[m][n]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (count[i][j] == buildingCount && distance[i][j] != 0 ) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs (int[][] grid, int i, int j, int m, int n, int[][] distance, int[][] count, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int steps = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k=0; k<size; k++) {
                int[] loc = queue.poll();
                if (grid[loc[0]][loc[1]] == 0) {
                    distance[loc[0]][loc[1]] += steps;
                    count[loc[0]][loc[1]]++;
                }
                for (int[] dir : dirs) {
                    int xx = loc[0] + dir[0];
                    int yy = loc[1] + dir[1];
                    if (xx >=0 && xx < m && yy >= 0 && yy < n && !visited[xx][yy] && grid[xx][yy] == 0) {
                        queue.offer(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
            steps++;
        }
    }

    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings app = new ShortestDistanceFromAllBuildings();
        int[][] grid = {{0,2,1},{1,0,2},{0,1,0}};
        System.out.println(app.shortestDistance(grid));
    }

}
