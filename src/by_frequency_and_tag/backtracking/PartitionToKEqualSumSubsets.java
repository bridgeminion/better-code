package by_frequency_and_tag.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        return helper(nums, 0, k, sum/k, sum/k, new HashSet<>());
    }

    private boolean helper(int[] nums, int index, int k, int left, int target, Set<Integer> set) {
        if (left == 0) {
            if (k == 1 && set.size() == nums.length) {
                return true;
            }
            return helper(nums, 0, k-1, target, target, set);
        }
        for (int i=index; i<nums.length; i++) {
            if (!set.contains(i) && nums[i] <= left) {
                set.add(i);
                if (helper(nums, i+1, k, left-nums[i], target, set)) {
                    return true;
                }
                set.remove(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets app = new PartitionToKEqualSumSubsets();
        int[] nums = {815,625,3889,4471,60,494,944,1118,4623,497,771,679,1240,202,601,883};
        System.out.println(app.canPartitionKSubsets(nums, 3));
    }
}
