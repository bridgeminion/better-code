package top_interview_questions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int minRow = 0, maxRow = matrix.length-1, minCol = 0, maxCol = matrix[0].length-1;
        while (minRow <= maxRow && minCol <= maxCol) {
            for (int i=minCol; i<=maxCol; i++) {
                result.add(matrix[minRow][i]);
            }
            minRow++;
            for (int i=minRow; i<=maxRow; i++) {
                result.add(matrix[i][maxCol]);
            }
            maxCol--;
            // Add check here to avoid output more elements than matrix size
            if (minRow > maxRow || minCol > maxCol) {
                break;
            }
            for (int i=maxCol; i>=minCol; i--) {
                result.add(matrix[maxRow][i]);
            }
            maxRow--;
            for (int i=maxRow; i>=minRow; i--) {
                result.add(matrix[i][minCol]);
            }
            minCol++;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix instance = new SpiralMatrix();
        int[][] spiral = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(instance.spiralOrder(spiral));
    }

}
