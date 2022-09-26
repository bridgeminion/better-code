package linkedIn_high_frequency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionToKEqualSumSubsets {
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<k; i++) {
            helper(nums, sum/4, new ArrayList<>(), result);
        }

        return result;
    }

    private void helper(int[] nums, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList(list));
            set.addAll(list);
        }
        for (int i=0; i<nums.length; i++) {
            if (list.contains(nums[i]) || set.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, target-nums[i], list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets app = new PartitionToKEqualSumSubsets();
        int[] nums = {4,3,2,3,5,2,1};
        System.out.println(app.canPartitionKSubsets(nums, 4));
    }


}
