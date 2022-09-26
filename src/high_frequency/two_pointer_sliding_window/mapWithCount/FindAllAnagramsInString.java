package high_frequency.two_pointer_sliding_window.mapWithCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        int right = 0, count = p.length();
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && count > 0) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    if (map.get(c) > 0) {
                        count--;
                    }
                    map.put(c, map.get(c) - 1);
                }
                right++;
            }
            if (count == 0) {
                if (p.length() == right - left) {
                    result.add(left);
                }
            }
            char c = s.charAt(left);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if (map.get(c) > 0) {
                    count++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsInString instance = new FindAllAnagramsInString();
        System.out.println(instance.findAnagrams("abab", "ab"));
    }

}
