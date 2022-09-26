package top_interview_questions;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int sum = stack.pop() + stack.pop();
                stack.push(sum);
            }
            else if ("-".equals(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int subtract = num2 - num1;
                stack.push(subtract);
            } else if ("*".equals(token)) {
                int sum = stack.pop() * stack.pop();
                stack.push(sum);
            } else if ("/".equals(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int division = num2/num1;
                stack.push(division);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation instance = new EvaluateReversePolishNotation();
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(instance.evalRPN(tokens));
    }

}
