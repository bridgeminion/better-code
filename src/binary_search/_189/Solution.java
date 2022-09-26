package binary_search._189;

public class Solution {
    public void rotate(int[] nums, int k) {
        rotateArray(nums, 0, k);
        rotateArray(nums, k+1, nums.length - 1);
        rotateArray(nums, 0, nums.length - 1);

    }

    private void rotateArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        solution.rotate(nums, 3);
    }

}
