package top_interview_questions;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<Integer, Integer> memo = new HashMap<>();
        int max = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                max = Math.max(max, helper(matrix, i, j, m, n, memo));
            }
        }

        return max;
    }

    private int helper(int[][] matrix, int i, int j, int m, int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(i*n+j)) {
            return memo.get(i*n+j);
        }
        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int max = 0;
        for (int[] move : moves) {
            int nextX = i + move[0];
            int nextY = j + move[1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && matrix[nextX][nextY] > matrix[i][j]) {
                max = Math.max(max, helper(matrix, nextX, nextY, m, n, memo));
            }
        }
        memo.put(i*n+j, max + 1);
        return max + 1;
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix instance = new LongestIncreasingPathInAMatrix();
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(instance.longestIncreasingPath(matrix));
    }

}
