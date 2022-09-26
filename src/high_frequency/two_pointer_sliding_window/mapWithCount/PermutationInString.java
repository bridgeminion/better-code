package high_frequency.two_pointer_sliding_window.mapWithCount;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int right = 0, count = s1.length();
        for (int left = 0; left < s2.length(); left++) {
            while (right < s2.length() && count > 0) {
                char c = s2.charAt(right);
                if (map.containsKey(c)) {
                    if (map.get(c) > 0) {
                        count--;
                    }
                    map.put(c, map.get(c) - 1);
                }
                right++;
            }
            if (count == 0) {
                if (right - left == s1.length()) {
                    return true;
                }
                char c = s2.charAt(left);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
                        count++;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString instance = new PermutationInString();
        System.out.println(instance.checkInclusion("ab", "eidboaoo"));
    }

}
