package by_frequency_and_tag.dfs;

import java.util.*;

public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 2, max = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    int size = floodFill(grid, i, j, m, n, index);
                    map.put(index, size);
                    max = Math.max(max, size);
                    index++;
                }
            }
        }
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int sum = 0;
                    Set<Integer> set = new HashSet<>();
                    set.add(i + 1 < m ? grid[i + 1][j] : 0);
                    set.add(i - 1 >= 0 ? grid[i - 1][j] : 0);
                    set.add(j + 1 < n ? grid[i][j + 1] : 0);
                    set.add(j - 1 >= 0 ? grid[i][j - 1] : 0);
                    for (int neighbor : set) {
                        sum += map.getOrDefault(neighbor, 0);
                    }
                    max = Math.max(max, sum+1);
                }
            }
        }

        return max;
    }

    private int floodFillDFS(int[][] grid, int i, int j, int m, int n, int index) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        return 1 + floodFill(grid, i+1, j, m, n, index)
                + floodFill(grid, i-1, j, m, n, index)
                + floodFill(grid, i, j+1, m, n, index)
                + floodFill(grid, i, j-1, m, n, index);
    }

    private int floodFill(int[][] grid, int i, int j, int m, int n, int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        grid[i][j] = index;
        int size = 0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            size++;
            for (int[] dir : dirs) {
                int newX = point[0] + dir[0];
                int newY = point[1] + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                    grid[newX][newY] = index;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return size;
    }


    public static void main(String[] args) {
        MakingALargeIsland app = new MakingALargeIsland();
        int[][] grid = {{1,1}, {1,1}};
        System.out.println(app.largestIsland(grid));
    }

//    class Pair {
//        int x;
//        int y;
//        boolean canflip;
//        public Pair (int x, int y, boolean canFlip) {
//            this.x = x;
//            this.y = y;
//            this.canflip = canFlip;
//        }
//    }
//    public int largestIsland(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int max = 0;
//        boolean[][] visited = new boolean[m][n];
//        for (int i=0; i<m; i++) {
//            for (int j=0; j<n; j++) {
//                if (grid[i][j] == 1 && !visited[i][j]) {
//                    max = Math.max(max, bfs(grid, m, n, i, j, visited));
//                }
//            }
//        }
//
//        return max;
//    }
//
//    private int bfs(int[][] grid, int m, int n, int i, int j, boolean[][] visited) {
//        Queue<Pair> queue = new LinkedList<>();
//        queue.offer(new Pair(i, j, true));
//        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
//        visited[i][j] = true;
//        int size = 0;
//        while (!queue.isEmpty()) {
//            Pair pair = queue.poll();
//            size++;
//            for (int[] dir : dirs) {
//                int newX = i + dir[0];
//                int newY = j + dir[1];
//                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
//                    if (grid[newX][newY] == 1) {
//                        queue.offer(new Pair(newX, newY, true));
//                        visited[newX][newY] = true;
//                    } else if (pair.canflip) {
//                        queue.offer(new Pair(newX, newY, false));
//                        visited[newX][newY] = true;
//                    }
//                }
//            }
//        }
//
//        return size;
//    }

}
