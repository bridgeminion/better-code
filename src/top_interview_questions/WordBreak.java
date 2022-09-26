package top_interview_questions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    // exceeds time limit
    public boolean wordBreak1(String s, List<String> wordDict) {
        return helper1(s, wordDict);
    }

    private boolean helper1(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        for (String dict : wordDict) {
            if (s.startsWith(dict)) {
                if (helper1(s.substring(dict.length()), wordDict)) {
                    return true;
                }
            }
        }

        return false;
    }

    // DFS with memorization
    public boolean wordBreakDFS(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        return helper(s, 0, wordDict, set);

    }

    private boolean helper(String s, int i, List<String> wordDict, Set<Integer> set) {
        if (i == s.length()) {
            return true;
        }
        for (int j=i+1; j<=s.length(); j++) {
            if (set.contains(j)) {
                continue;
            }
            if (wordDict.contains(s.substring(i, j))) {
                if (helper(s, j, wordDict, set)) {
                    return true;
                }
                set.add(j);
            }
        }
        return false;
    }

    // dp[i] means if breakable [0, i)
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

}
