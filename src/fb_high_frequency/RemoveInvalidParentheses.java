package fb_high_frequency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0, leftRemove = 0, rightRemove = 0;
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                left++;
            } else if (')' == c) {
                if (left == 0) {
                    rightRemove++;
                } else {
                    left--;
                }
            }
        }
        leftRemove = left;
        Set<String> result = new HashSet<>();
        dfs(leftRemove, rightRemove, s, result);

        return new ArrayList(result);
    }

    private void dfs(int left, int right, String str, Set<String> result) {
        if (left == 0 && right == 0) {
            if (isValid(str)) {
                result.add(str);
            }
            return;
        }
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(' && left > 0) {
                dfs( left-1, right, str.substring(0, i) + str.substring(i+1), result);
            } else if(str.charAt(i) == ')' && right > 0) {
                dfs(left, right-1, str.substring(0, i) + str.substring(i+1), result);
            }
        }
    }

    private boolean isValid(String s) {
        int l = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    return false;
                }
            }
        }
        return l == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses app = new RemoveInvalidParentheses();
        System.out.println(app.removeInvalidParentheses("(a)())()"));
    }

}
