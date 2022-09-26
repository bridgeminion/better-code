package bfs._301;

import common.TreeNode;

import java.util.*;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */
public class Solution {

    /** minimum number of removal indicates BFS
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        boolean done = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    result.add(str);
                    done = true;
                }
                // once done, no longer add more to queue
                if (done) {
                    continue;
                }
                for (int j=0; j<str.length(); j++) {
                    if (str.charAt(j) == '(' || str.charAt(j) == ')') {
                        String newStr = str.substring(0, j) + str.substring(j+1);
                        if (!visited.contains(newStr)) {
                            queue.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count <= 0) {
                    return false;
                }
                count--;
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeInvalidParentheses("(a)())()"));
    }

}
