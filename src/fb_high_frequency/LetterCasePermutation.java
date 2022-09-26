package fb_high_frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * a1b2
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(s, 0, "", result);

        return result;
    }

    private void helper(String s, int index, String str, List<String> result) {
        if (index == s.length()) {
            result.add(str);
            return;
        }
        if (Character.isLetter(s.charAt(index))) {
            char toggled = Character.isLowerCase(s.charAt(index)) ? Character.toUpperCase(s.charAt(index)) : Character.toLowerCase(s.charAt(index));
            helper(s, index + 1, str + toggled, result);
        }
        helper(s, index + 1, str + s.charAt(index), result);
    }

    public static void main(String[] args) {
        LetterCasePermutation app = new LetterCasePermutation();
        System.out.println(app.letterCasePermutation("A1b2"));
    }
}
