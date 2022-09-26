package by_frequency_and_tag.dp;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        int count = s.length();
        for (int i=m-1; i>=0 ; i--) {
            for (int j=i+1; j<m; j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings app = new PalindromicSubstrings();
        System.out.println(app.countSubstrings("abc"));
    }

}
