package top_interview_questions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(String s, int i, List<String> list, List<List<String>> result) {
        if (i == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int k=i+1; k<=s.length(); k++) {
            String subStr = s.substring(i, k);
            if (isPalindrome(subStr)) {
                list.add(subStr);
                helper(s, k, list, result);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length()-1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning instance = new PalindromePartitioning();
        System.out.println(instance.partition("aab"));
    }

}
