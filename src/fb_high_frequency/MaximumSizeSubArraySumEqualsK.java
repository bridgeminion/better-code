package fb_high_frequency;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // 0 means from start of array
        int sum = 0, max = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) { // never override a key since we want max size
                map.put(sum, i);
            }
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumSizeSubArraySumEqualsK app = new MaximumSizeSubArraySumEqualsK();
        int[] nums = {1, -1, 5, -2, 3};
        System.out.println(app.maxSubArrayLen(nums, 3));
    }

}
