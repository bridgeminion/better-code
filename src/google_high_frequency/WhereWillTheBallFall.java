package google_high_frequency;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            result[i] = canFall(i, grid, m, n);
        }

        return result;
    }

    private int canFall(int j, int[][] grid, int m, int n) {
        for (int i=0; i<m; i++) {
            int num = grid[i][j];
            if (j+num < 0 || j+num >= n || num != grid[i][j+num]) {
                return -1;
            }
            j = j + num;
        }
        return j;
    }

    public static void main(String[] args) {
        WhereWillTheBallFall app = new WhereWillTheBallFall();
        int[][] grid = {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
        System.out.println(app.findBall(grid));
    }


}
