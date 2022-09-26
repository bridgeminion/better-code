package top_interview_questions;

/**
 * complexity: all the way down and all the way left. (m+n)
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n-1;
        while (row < m && col >= 0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            }
            if (target < num) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

}
