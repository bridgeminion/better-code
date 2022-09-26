package sliding_window._30;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once,
 * in any order, and without any intervening characters.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        final Map<String, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> result = new ArrayList<>();
        int wl = words[0].length();
        int count = map.size();
        for (int left=0; left <= s.length() - wl * words.length; left++) {
            Map<String, Long> clone = new HashMap<>(map);
            int right = left;
            while (right + wl <= s.length()) {
                String str = s.substring(right, right + wl);
                if (clone.containsKey(str)) {
                    clone.put(str, clone.get(str) - 1);
                    if (clone.get(str) < 0) {
                        count = map.size();
                        break;
                    }
                    if (clone.get(str) == 0) {
                        count--;
                    }
                    right += wl;
                    if (count == 0) {
                        result.add(left);
                        count = map.size();
                        break;
                    }
                } else {
                    count = map.size();
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"word","good","best","good"};
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", words));
    }
}
