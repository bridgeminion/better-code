package top_interview_questions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            char c = chars[i];
            if ((c == 'I' && i<chars.length - 1 && (chars[i+1] == 'V' || chars[i+1] == 'X')) ||
                (c == 'X' && i<chars.length - 1 && (chars[i+1] == 'L' || chars[i+1] == 'C')) ||
                (c == 'C' && i<chars.length - 1 && (chars[i+1] == 'D' || chars[i+1] == 'M'))) {
                sum -= map.get(c);
            } else {
                sum += map.get(c);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger instance = new RomanToInteger();
        System.out.println(instance.romanToInt("MCMXCIV"));
    }

}
