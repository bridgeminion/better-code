package by_frequency_and_tag.dp;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0;
        for (int i=0; i<nums.length; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    length = Math.max(length, dp[i]);
                }
            }
        }

        return length;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence app = new LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(app.lengthOfLIS(nums));
    }

}
