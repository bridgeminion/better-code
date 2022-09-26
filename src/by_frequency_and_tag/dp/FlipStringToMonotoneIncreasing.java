package by_frequency_and_tag.dp;

public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int m = s.length();
        int[][] dp = new int[m][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
        for (int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + s.charAt(i)-'0';
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + (s.charAt(i) == '1' ? 0 : 1);
        }

        return Math.min(dp[m-1][0], dp[m-1][1]);
    }

    public int minFlipsMonoIncrWithoutArray(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int endZero = 0, endOne = 0;
        for (char c : s.toCharArray()) {
            endOne = Math.min(endZero, endOne) + (c == '1' ? 0 : 1);
            endZero = endZero + c - '0';
        }

        return Math.min(endOne, endZero);
    }

    public static void main(String[] args) {
        FlipStringToMonotoneIncreasing app = new FlipStringToMonotoneIncreasing();
        System.out.println(app.minFlipsMonoIncr("010110"));
    }

}
