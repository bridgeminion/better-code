package top_interview_questions;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] min = new int[len];
        int[] max = new int[len];
        int result = nums[0];
        min[0] = max[0] = nums[0];
        for(int i = 1; i < len; i++){
            if(nums[i] > 0){
                max[i] = Math.max(nums[i], nums[i] * max[i-1]);
                min[i] = Math.min(nums[i], nums[i] * min[i-1]);
            }
            else if(nums[i] < 0){
                max[i] = Math.max(nums[i], nums[i] * min[i-1]);
                min[i] = Math.min(nums[i], nums[i] * max[i-1]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubArray instance = new MaximumProductSubArray();
        int[] nums = {2,3,-2,4};
        System.out.println(instance.maxProduct(nums));
    }

}
