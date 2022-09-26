package high_frequency.basic_dfs;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        if (digits.equals("")) {
            return result;
        }
        helper(digits, map, result, "", 0);

        return result;
    }

        private void helper(String digits, Map<Character, String> map, List<String> result, String s, int pos) {
        if (pos == digits.length()) {
            result.add(s);
            return;
        }
        String str = map.get(digits.charAt(pos));
        for (char c : str.toCharArray()) {
            helper(digits, map, result, s+c, pos+1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber instance = new LetterCombinationsOfPhoneNumber();
        System.out.println(instance.letterCombinations(""));
    }

}
