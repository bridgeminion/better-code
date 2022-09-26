package high_frequency.pre_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * use prefix sum, map to keep track of prefix sum and frequency
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public int subarraySumSLow(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i == 0) {
                prefixSum[i] = nums[i];
            } else {
                prefixSum[i] = prefixSum[i-1] + nums[i];
            }
        }
        int count = 0;
        for (int i=0; i<prefixSum.length; i++) {
            if (prefixSum[i] == k) {
                count++;
            }
            for (int j=0; j<i; j++) {
                if (prefixSum[i] - prefixSum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        SubarraySumEqualsK instance = new SubarraySumEqualsK();
        int[] nums = {-1,1,-4,4,-2,2,5};
        System.out.println(instance.subarraySum(nums, 5));;
    }

}
