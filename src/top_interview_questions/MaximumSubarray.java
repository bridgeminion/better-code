package top_interview_questions;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] prefix = new int[nums.length];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (i == 0) {
                prefix[i] = nums[i];
                max = nums[i];
            } else {
                prefix[i] = prefix[i-1] + nums[i];
                max = Math.max(max, prefix[i] - min);
            }
            min = Math.min(min, prefix[i]);
            System.out.println("sum=" + max + ", minsum=" + min);
        }

        return max;
    }

    public int maxSubArray1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        // write your code
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minsum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - minsum);
            minsum = Math.min(minsum, sum);
            System.out.println("sum=" + sum + ", minsum=" + minsum);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray instance = new MaximumSubarray();
        int[] nums = {5,4,-1,7,8};
        System.out.println(instance.maxSubArray(nums));
    }

}
