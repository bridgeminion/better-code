package high_frequency.calculation;

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
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                if (i < s.length()-1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
                    sum -= map.get(c);
                } else {
                    sum += map.get(c);
                }
            } else if (c == 'X') {
                if (i < s.length()-1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                    sum -= map.get(c);
                } else {
                    sum += map.get(c);
                }
            } else if (c == 'C') {
                if (i < s.length()-1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                    sum -= map.get(c);
                } else {
                    sum += map.get(c);
                }
            } else {
                sum += map.get(c);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger instance = new RomanToInteger();
        System.out.println(instance.romanToInt("IV"));
    }

}
