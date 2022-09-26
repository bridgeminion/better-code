package top_interview_questions;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        s = "#" + s;
        p = "#" + p;
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (s1[i] == p1[j] || p1[j] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p1[j] == '*') {
                    dp[i][j] = dp[i][j-2] || s1[i] == p1[j-1] && dp[i-1][j-2];
                }
            }
        }

        return dp[m][n];
    }

}
