package top_interview_questions;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence instance = new LongestIncreasingSubsequence();
        int[] nums = {5,1,2,3,4,7};
        System.out.println(instance.lengthOfLIS(nums));
    }
}
