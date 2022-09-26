package by_frequency_and_tag.dp;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int m = s.length(), max = 0;
        boolean[][] dp = new boolean[m][m];
        String result = null;
        for (int j=0; j<m; j++) {
            for (int i=j; i>=0; i--) {
                if (s.charAt(j) == s.charAt(i) && (j-i < 3 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (j-i+1 > max) {
                        max = Math.max(max, j-i+1);
                        result = s.substring(i, j+1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring app = new LongestPalindromicSubstring();
        System.out.println(app.longestPalindrome("babad"));
    }
}
