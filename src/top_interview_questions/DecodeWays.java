package top_interview_questions;

/**
 * if no restriction on A->Z, zero, dp[i] = dp[i-1] + dp[i-2]
 * find out valid cases for one digit and two digits
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i=1; i<s.length(); i++) {
            int oneDigit = s.charAt(i) - '0';
            int twoDigit = Integer.parseInt(s.substring(i-1, i+1));
            if (oneDigit >=1 && oneDigit <= 9) {
                dp[i+1] += dp[i];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i+1] += dp[i-1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays instance = new DecodeWays();
        System.out.println(instance.numDecodings("2101"));
    }

}
