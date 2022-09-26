package google_high_frequency;

public class LongestLineOfConsecutiveOnesInMatrix {
    public class Solution {
        /**
         * @param M: the 01 matrix
         * @return: the longest line of consecutive one in the matrix
         */
        public int longestLine(int[][] M) {
            if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
                return 0;
            }
            int m = M.length, n = M[0].length;
            int result = 0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (M[i][j] == 1) {
                        int len = helper(i, j, M, m, n);
                        result = Math.max(result, len);
                    }
                }
            }

            return result;
        }

        private int helper(int i, int j, int[][] grid, int m, int n) {
            int[][] moves = {{0,1}, {1,0}, {1,1}, {1,-1}};
            int max = 0;
            for (int[] move : moves) {
                int nextX = i + move[0];
                int nextY = j + move[1];
                int count = 1;
                while (nextX >=0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                    count++;
                    nextX += move[0];
                    nextY += move[1];
                }
                max = Math.max(max, count);
            }

            return max;
        }
    }
}
