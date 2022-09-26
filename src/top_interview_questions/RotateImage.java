package top_interview_questions;

/**
 * if clockwise rotate, bottom up first, then swap the symmetry
 * if anti-clockwise rotate, left right first, then swap the symmetry
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for (int i=0; i<row/2; i++) {
            for (int j=0; j<col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-i-1][j];
                matrix[row-i-1][j] = temp;
            }
        }
        /**
         * (0,1) <-> (1,0)
         * (0,2) <-> (2,0)
         * (1,2) <-> (2,1)
         */
        for (int i=0; i<row; i++) {
            for(int j=i+1; j<col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }



}
