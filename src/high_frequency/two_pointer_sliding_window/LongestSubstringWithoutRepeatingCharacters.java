package high_frequency.two_pointer_sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int right = 0, max = 0;
        Set<Character> set = new HashSet<>();
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - left);
            set.remove(s.charAt(left));
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters instance = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(instance.lengthOfLongestSubstring("pwwkew"));
    }

}
