package binary_search._153;

public class Solution {
    /**
     * for rotated array, always compare mid with right to cover not rotated array corner case
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        return nums[right];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,4,5,1,2};
        System.out.println(solution.findMin(nums));
    }

}
