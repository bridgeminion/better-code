package binary_search._154;

public class Solution {
    /**
     * for rotated array, always compare mid with right to cover not rotated array corner case
     * Worst case, O(n)
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
            } else if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right--;
            }
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        return nums[right];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,2,2,0,1};
        System.out.println(solution.findMin(nums));
    }

}
