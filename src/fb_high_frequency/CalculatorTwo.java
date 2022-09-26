package fb_high_frequency;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CalculatorTwo {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+';

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                num = 10 * num + (int) (current - '0');
            }

            if (current == '+' || current == '-' || current == '*' || current == '/' || i == n - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                sign = current;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();

        return result;
    }

    public static void main(String[] args) {
        CalculatorTwo app = new CalculatorTwo();
        System.out.println(app.calculate(" 3+5 / 2 "));
    }
}
