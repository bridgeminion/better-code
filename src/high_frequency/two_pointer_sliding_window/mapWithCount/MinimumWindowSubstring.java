package high_frequency.two_pointer_sliding_window.mapWithCount;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int right = 0, count = t.length();
        String minStr = "";
        for (int left=0; left < s.length(); left++) {
            while (right < s.length() && count > 0) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    if (map.get(c) > 0) { // only decrement count when > 0 means this char is needed
                        count--;
                    }
                    map.put(c, map.get(c) - 1);
                }
                right++;
            }
            if (count == 0) {
                if (minStr.equals("") || minStr.length() > right - left) {
                    minStr = s.substring(left, right);
                }
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0) { // only increment count when > 0 means this char is missing
                        count++;
                    }
                }
            }
         }

        return minStr;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring instance = new MinimumWindowSubstring();
        System.out.println(instance.minWindow("ADOBECODEBANC", "ABC"));
    }

}
