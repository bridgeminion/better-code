package binary_search._74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (matrix[mid/col][mid%col] == target) {
                return true;
            }
            if (matrix[mid/col][mid%col] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return matrix[left/col][left%col] == target || matrix[right/col][right%col] == target;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        System.out.println(solution.searchMatrix(matrix, 13));
    }

}
