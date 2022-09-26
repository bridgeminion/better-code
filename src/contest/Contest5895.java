package contest;

import java.util.Arrays;

public class Contest5895 {
    public int minOperations(int[][] grid, int x) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] array = new int[m*n];
        int k = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                array[k++] = grid[i][j];
            }
        }
        Arrays.sort(array);
        int max = Integer.MAX_VALUE;
        int start = Math.max(m*n/2-1, 0);
        int end = Math.min(m*n/2+1, array.length-1);
        for (int i=start; i<=end; i++) {
            max = Math.min(max, uni(array, array[i], x));
        }

        return max;

    }

    private int uni(int[] nums, int target, int x) {
        int count = 0;
        for (int num : nums) {
            int diff = Math.abs(target - num);
            if (diff % x != 0) {
                return -1;
            }
            count += diff/x;
        }

        return count;
    }

    public static void main(String[] args) {
        Contest5895 app = new Contest5895();
        int[][] grid = {{146}};
        System.out.println(app.minOperations(grid, 86));
    }
}
