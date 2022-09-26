package binary_search._88;

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                left++;
            }
        }

       return nums[left] == target || nums[right] == target;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println(solution.search(nums, 2));
    }
}
