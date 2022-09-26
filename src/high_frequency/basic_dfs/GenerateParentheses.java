package high_frequency.basic_dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, result, "", 0, 0);

        return result;
    }

    private void helper(int n, List<String> result, String s, int left, int right) {
        if (right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            helper(n, result, s+"(", left+1, right);
        }
        if (left > right) {
            helper(n, result, s+")", left, right+1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses instance = new GenerateParentheses();
        System.out.println(instance.generateParenthesis(1));
    }

}
