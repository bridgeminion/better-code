package high_frequency.pre_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), result, 0, target);

        return result;
    }

    private void helper(int[] nums, int sum, List<Integer> list, List<List<Integer>> result, int index, int target) {
        if (list.size() == 4 && sum == target && !result.contains(list))  {
            result.add(new ArrayList<>(list));
            return;
        }
        if (list.size() < 4) {
            if (sum + nums[nums.length-1]*(4-list.size()) < target) {
                return;
            }
            if (sum + nums[0]*(4-list.size()) > target) {
                return;
            }
            for (int i=index; i<nums.length; i++) {
                list.add(nums[i]);
                helper(nums, sum + nums[i], list, result, i+1, target);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        FourSum instance = new FourSum();
        int[] nums = {2,2,2,2,2};
        instance.fourSum(nums, 8);
    }

}
