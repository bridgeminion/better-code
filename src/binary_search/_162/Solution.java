package binary_search._162;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[mid - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[left] > nums[right]) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(solution.findPeakElement(nums));
    }

}
