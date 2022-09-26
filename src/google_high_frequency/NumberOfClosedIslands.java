package google_high_frequency;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(grid, i, j, m, n, visited)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (visited[i][j] || grid[i][j] == 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean result = true;
        for (int[] move : moves) {
            result &= dfs(grid, i + move[0], j + move[1], m, n, visited);
        }

        return result;
    }

    public int closedIslandWithModify(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    if (dfs1(grid, i, j, m, n)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs1(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean result = true;

        for (int[] move : moves) {
//            if (!dfs(grid, i + move[0], j + move[1], m, n)) {
//                return false;
//            }
            result = result & dfs1(grid, i + move[0], j + move[1], m, n);
        }

        return result;
    }


    public static void main(String[] args) {
        NumberOfClosedIslands app = new NumberOfClosedIslands();
//        int[][] grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        int[][] grid = {
                {0,0,1,1,0,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,0,1,1,0},
                {0,1,1,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,1,1,1,0},
                {0,1,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,1,0,0,0,1},
                {1,1,1,1,1,1,0,0,0,0},
                {1,1,1,0,0,1,0,1,0,1},
                {1,1,1,0,1,1,0,1,1,0}
        };
        System.out.println(app.closedIsland(grid));
    }
}
