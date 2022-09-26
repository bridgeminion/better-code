package high_frequency.two_pointer_sliding_window;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int right = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int left=0; left<nums.length; left++) {
            while (right < nums.length && sum < target) {
                sum += nums[right++];
            }
            if (sum >= target) {
                min = Math.min(min, right - left);
                sum -= nums[left];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum instance = new MinimumSizeSubarraySum();
        int[] nums = {1,4,4};
        System.out.println(instance.minSubArrayLen(4, nums));
    }

}
