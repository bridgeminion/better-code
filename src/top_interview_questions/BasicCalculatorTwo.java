package top_interview_questions;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorTwo {
    public int calculate1(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int num;
        s = "+" + s;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            num = 0;
            if (!Character.isDigit(c) && c != ' ') {
                int j = i+1;
                while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == ' ')) {
                    if (s.charAt(j) != ' ') {
                        num = num * 10 + s.charAt(j) - '0';
                    }
                    j++;
                }
                switch (c) {
                    case '+': stack.push(num);
                    break;
                    case '-': stack.push(-num);
                    break;
                    case '*': stack.push(num * stack.pop());
                    break;
                    case '/': stack.push(stack.pop()/num);
                    break;
                }
                i = j-1;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }

    public static void main(String[] args) {
        BasicCalculatorTwo instance = new BasicCalculatorTwo();
        System.out.println(instance.calculate(" 2+ 3/2  "));
    }

}
