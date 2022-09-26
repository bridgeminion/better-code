package google_high_frequency;

import java.util.HashMap;
import java.util.Map;

public class PalindromepartitioningTwo {
    public int minCut(String s) {
        Map<Integer, Integer> map = new HashMap<>();

        return helper(s, 0, map) - 1;
    }

    private int helper(String s, int index, Map<Integer, Integer> map) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        if (index == s.length()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i=index+1; i<=s.length(); i++) {
            String str = s.substring(index, i);
            if (isPalindrome(str)) {
                min = Math.min(min, 1 + helper(s, i, map));
            }
        }
        map.put(index, min);
        return min;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromepartitioningTwo app = new PalindromepartitioningTwo();
        System.out.println(app.minCut("aab"));
    }

}
