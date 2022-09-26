package top_interview_questions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, n, "", result);

        return result;
    }

    private void helper(int left, int right, String s, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            helper(left-1, right, s + "(", result);
        }
        if (left < right) {
            helper(left, right-1, s+")", result);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses instance = new GenerateParentheses();
        System.out.println(instance.generateParenthesis(3));
    }
}
