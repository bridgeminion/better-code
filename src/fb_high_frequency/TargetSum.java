package fb_high_frequency;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return helper(nums, 0, target, map);

    }

    private int helper(int[] nums, int i, int sum, Map<String, Integer> map) {
        String key = String.format("%d:%d", i, sum);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (i == nums.length) {
            if (sum == 0) {
                return 1;
            }
            return 0;
        }
        int add = helper(nums, i+1, sum - nums[i], map);
        int subtract = helper(nums, i+1, sum + nums[i], map);
        map.put(key, add+subtract);
        return map.get(key);
    }

    public static void main(String[] args) {
        TargetSum app = new TargetSum();
        int[] nums = {1,1,1};
        System.out.println(app.findTargetSumWays(nums, 2));
    }

}
