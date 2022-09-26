package top_interview_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        for (int i=0;i<numRows; i++) {
            for (int j=0; j<=i; j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }

        for (int i=0;i<numRows; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                l.add(dp[i][j]);
            }
            list.add(l);
        }

        return list;
    }

}
