package google_high_frequency;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    int max = 0;
    public int maxLength(List<String> arr) {
        for (int i=0; i<arr.size(); i++) {
            helper(arr, arr.get(i), i+1);
        }
        return max;
    }

    private void helper(List<String> arr, String s, int index) {
        if (!isUnique(s)) {
            return;
        }
        max = Math.max(max, s.length());
        if (index < arr.size()) {
            for (int i = index; i<arr.size(); i++) {
                helper(arr, s + arr.get(i), i+1);
            }
        }
    }

    private boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }

        return true;
    }

    public static void main(String[] args) {
        MaximumLengthOfAConcatenatedStringWithUniqueCharacters app = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
        List<String> arr = Arrays.asList("cha","r","act","ers");
        System.out.println(app.maxLength(arr));
    }

}
