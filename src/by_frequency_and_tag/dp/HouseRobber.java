package by_frequency_and_tag.dp;

public class HouseRobber {
    public int rob(int[] nums) {
        int m = nums.length;
        int[][] dp = new int[m][2];
        dp[0][1] = nums[0];
        for (int i=1; i<m; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[m-1][0], dp[m-1][1]);
    }

     public int robOneDimension(int[] nums) {
         int m = nums.length;
         int[] dp = new int[m];
         dp[0] = nums[0];
         if (m == 1) {
             return dp[0];
         }
         dp[1] = Math.max(nums[0], nums[1]);
         for (int i=2; i<m; i++) {
             dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
         }
         return dp[m-1];
     }

}
