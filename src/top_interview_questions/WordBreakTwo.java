package top_interview_questions;

import java.util.*;

public class WordBreakTwo {
    public List<String> wordBreak1(String s, List<String> wordDict) {
        Set<String> dic = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        helper(s, 0, dic, result, "");

        return result;
    }

    private void helper(String s, int index, Set<String> dic, List<String> result, String str) {
        if (index == s.length()) {
            result.add(str);
            return;
        }
        for (int j=index+1; j<=s.length(); j++) {
            String subStr = s.substring(index, j);
            if (dic.contains(subStr)) {
                String temp = str;
                str = str.length() == 0 ? subStr : str + " " + subStr;
                helper(s, j, dic, result, str);
                str = temp;
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>();
        List<String> result = new ArrayList<>();
        return helper(s, wordDict, memo);
    }

    private List<String> helper(String s, List<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> list = new ArrayList<>();
        if (s.isEmpty()) {
            list.add("");
            return list;
        }
        for (String d : dict) {
            if (s.startsWith(d)) {
                List<String> results = helper(s.substring(d.length()), dict, memo);
                for (String result : results) {
                    list.add(d + ("".equals(result) ? "" : " " + result));
                }
            }
        }
        memo.put(s, list);
        return list;
    }


    public static void main(String[] args) {
        WordBreakTwo instance = new WordBreakTwo();
        List<String> dic = Arrays.asList("cat","cats","and","sand","dog");
        System.out.println(instance.wordBreak("catsanddog", dic));
    }

}
