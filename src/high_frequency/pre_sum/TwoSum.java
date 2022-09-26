package high_frequency.pre_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSumSort(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left, right};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int first = nums[i];
            if (map.containsKey(first)) {
                return new int[]{map.get(first), i};
            } else {
                map.put(target - first, i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSum instance = new TwoSum();
        int[] nums = {2,2};
        instance.twoSum(nums, 4);
    }


}
