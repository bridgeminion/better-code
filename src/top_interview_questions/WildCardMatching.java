package top_interview_questions;

public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        s = "#" + s;
        p = "#" + p;
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m][n];
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        dp[0][0] = true;
        for (int j=1; j<n; j++) {
            if (p1[j] == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (s1[i] == p1[j] || p1[j] == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p1[j] == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        WildCardMatching instance = new WildCardMatching();
        System.out.println(instance.isMatch("cb", "?a"));
    }

}
