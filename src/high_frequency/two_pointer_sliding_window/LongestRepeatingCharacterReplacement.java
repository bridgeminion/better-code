package high_frequency.two_pointer_sliding_window;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it
 * to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int left = 0;
        int right = 0;
        char prev = '0';
        int k1 = k;

        while (right < s.length()) {
            char curr = s.charAt(right);
            if (prev == '0') {
                prev = curr;
                right++;
            } else if (prev == curr) {
                right++;
            } else if (k1 > 0) {
                k1--;
                right++;
            }
            max = Math.max(max, right - left);
            while (left < s.length() && s.charAt(left) == prev) {
                left++;
                right = left;
                k1 = k;
                prev = '0';
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement instance = new LongestRepeatingCharacterReplacement();
        System.out.println(instance.characterReplacement("ABAB", 2));
    }
}
