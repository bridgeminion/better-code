package by_frequency_and_tag.backtracking;


import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, n, "", result);

        return result;
    }

    private void helper(int left, int right, String str, List<String> result) {
        System.out.println("calling with left=" + left + ", right=" + right);
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left > 0) {
            helper(left-1, right, str+"(", result);
        }
        if (left < right) {
            helper(left, right-1, str+")", result);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses app = new GenerateParentheses();
        System.out.println(app.generateParenthesis(3));
    }
}
