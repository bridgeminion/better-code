package google_high_frequency;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
    public String decodeStringRecursive(String s) {
        char[] chars = s.toCharArray();
        int k = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                k = k*10 + chars[i] - '0';
            } else if (chars[i] == '[') {
                int count = 1, j = i+1;
                while (j < s.length()) {
                    if (chars[j] == '[') {
                        count++;
                    } else if (chars[j] == ']') {
                        count--;
                        if (count == 0) {
                            break;
                        }
                    }
                    j++;
                }
                String sub = decodeString(s.substring(i+1, j));
                for (int a=0; a<k; a++) {
                    sb.append(sub);
                }
                i = j;
                k = 0;
            } else {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }

    public String decodeString1(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        return helper(queue);

    }

    private String helper(Deque<Character> queue) {
        int i = 0, k = 0;
        StringBuilder sb = new StringBuilder();
        while (i < queue.size()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                k = 10*k + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                for (int j=0; j<k; j++) {
                    sb.append(sub);
                }
                k = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String decodeString(String s) {
        Stack <Integer> num = new Stack<>();
        Stack <String> str = new Stack<>();
        String currStr = "";
        int currNum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            } else if (c == '['){
                // At the starting of square bracket push the past strings in string stack and num for future string in num stack
                num.push(currNum);
                str.push(currStr);
                currNum = 0;
                currStr = "";
            } else if ( c == ']'){
                // At end of square bracket process the past string
                int times = num.pop();
                StringBuilder newStr = new StringBuilder(); // newString = ""
                for(int j = 0;j < times; j++){
                    newStr.append(currStr);
                }
                currStr = str.pop();
                currStr += newStr;
            } else {
                currStr += c;
            }
        }
        return currStr;
    }

    public static void main(String[] args) {
        DecodeString app = new DecodeString();
        System.out.println(app.decodeString("3[a2[c]]"));
    }
}
