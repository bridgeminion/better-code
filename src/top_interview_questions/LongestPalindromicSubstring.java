package top_interview_questions;

/**
 * dp start from the end of string
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int len = s.length();
        String result = "";
        boolean[][] dp = new boolean[len+1][len+1];
        for (int i=len-1; i>=0; i--) {
            for (int j=i; j<len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i < 3 || dp[i+1][j-1]);
                if (dp[i][j] && j-i+1 > result.length()) {
                    result = s.substring(i, j+1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring instance = new LongestPalindromicSubstring();
        System.out.println(instance.longestPalindrome("abba"));
    }

}
