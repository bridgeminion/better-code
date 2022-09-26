package binary_search._35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target <= nums[left]) {
            return left;
        }
        if (target <= nums[right]) {
            return right;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,5,16};
        System.out.println(solution.searchInsert(nums, 7));
    }

}
