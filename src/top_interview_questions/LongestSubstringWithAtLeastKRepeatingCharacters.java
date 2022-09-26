package top_interview_questions;

import java.util.HashMap;
import java.util.Map;

/**
 * divide the string into subStrings by < k, recursively call
 * ending condition is no chars with less than k times, just return string length
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean flag = false;
        for (int value : map.values()) {
            if (value < k) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return s.length();
        }
        int j, max = 0;
        for (int i=0; i<s.length(); i++) {
            if (map.get(s.charAt(i)) < k) {
                continue;
            }
            j = i;
            while (j < s.length() && map.get(s.charAt(j)) >= k) {
                j++;
            }
            max = Math.max(max, longestSubstring(s.substring(i, j), k));
            i = j;
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingCharacters instance = new LongestSubstringWithAtLeastKRepeatingCharacters();
        System.out.println(instance.longestSubstring("ababbc", 2));
    }

}
