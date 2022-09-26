package fb_high_frequency;

public class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        bfs(grid, grid[row][col], row, col, m, n, visited);
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }

    private void bfs(int[][] grid, int val, int i, int j, int m, int n, boolean[][] visited) {
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j] != val) {
            return;
        }
        if (isBorder(i, j, grid, m, n)) {
            grid[i][j] = -val;
        }
        visited[i][j] = true;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] dir : dirs) {
            bfs(grid, val, i+dir[0], j+dir[1], m, n, visited);
        }
    }

    private boolean isBorder(int i, int j, int[][] grid, int m, int n) {
        return i==0 || i==m-1 || j==0 || j==n-1 || grid[i][j] != grid[i-1][j]
                || grid[i][j] != grid[i][j-1]
                || grid[i][j] != grid[i+1][j]
                || grid[i][j] != grid[i][j+1];
    }

    public static void main(String[] args) {
        ColoringABorder app = new ColoringABorder();
        int[][] grid = {{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}};
        app.colorBorder(grid, 1, 3, 1);
    }

}
