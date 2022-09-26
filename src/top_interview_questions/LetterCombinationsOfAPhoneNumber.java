package top_interview_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        helper(digits, 0, map, result, "");

        return result;
    }

    private void helper(String digits, int i, Map<Character, String> map, List<String> result, String str) {
        if (i == digits.length()) {
            result.add(str);
            return;
        }
        String s = map.get(digits.charAt(i));
        for (char c : s.toCharArray()) {
            helper(digits, i+1, map, result, str + c);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber instance = new LetterCombinationsOfAPhoneNumber();
        System.out.println(instance.letterCombinations("2"));
    }
}
