package binary_search._34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int left = 0, right = nums.length - 1;
        int leftIndex, rightIndex;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) {
            leftIndex = left;
        } else if (nums[right] == target) {
            leftIndex = right;
        } else {
            leftIndex = -1;
        }
        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[right] == target) {
            rightIndex = right;
        } else if (nums[left] == target) {
            rightIndex = left;
        } else {
            rightIndex = -1;
        }
        return new int[]{leftIndex, rightIndex};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,7,7,8,8,10};
        System.out.println(solution.searchRange(nums, 8));
    }

}
