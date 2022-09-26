package top_interview_questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1. check stack.isEmpty() before pop()
 * 2. check if stack isEmpty() at the end
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (c == ')' && (stack.isEmpty() || stack.pop() != '(') ||
                    c == '}' && (stack.isEmpty() || stack.pop() != '{') ||
                    c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses instance = new ValidParentheses();
        System.out.println(instance.isValid("()[]("));
    }
}
