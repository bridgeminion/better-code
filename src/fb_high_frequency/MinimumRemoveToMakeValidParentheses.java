package fb_high_frequency;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValidWithSB(String s) {
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> toDelete = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    toDelete.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            toDelete.add(stack.pollLast()); // pollLast to make sure index in reversed order
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i=toDelete.size()-1; i>=0 ; i--) {
            sb.deleteCharAt(toDelete.get(i));
        }

        return sb.toString();
    }

    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new LinkedList<>();
        String[] split = s.split("");
        List<Integer> toDelete = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    toDelete.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            toDelete.add(stack.pop());
        }
        for (int i : toDelete) {
            split[i] = "";
        }

        return String.join("", split);
    }


    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses app = new MinimumRemoveToMakeValidParentheses();
        System.out.printf(app.minRemoveToMakeValid("))(("));
    }
}
