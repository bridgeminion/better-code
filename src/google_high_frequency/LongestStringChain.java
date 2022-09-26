package google_high_frequency;

import java.util.*;

public class LongestStringChain {
    public int longestStrChainDFS(String[] words) {
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet(Arrays.asList(words));
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        for (int i=words.length-1; i>=0; i--) {
            if (i >= max) {
                max = Math.max(max, helper(words, words[i], set, map));
            }
        }

        return max;
    }

    private int helper(String[] words, String word, Set<String> set, Map<String, Integer> map) {
        if (map.containsKey(word)) {
            return map.get(word);
        }
        int max = 1;
        for (int i=0; i<word.length(); i++) {
            String next = word.substring(0, i) + word.substring(i+1);
            if (set.contains(next)) {
                max = Math.max(max, 1+helper(words, next, set, map));
            }
        }

        map.put(word, max);
        return max;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, 1);
        }
        int max = 0;
        for (String word : words) {
            for (int i=0; i<word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i+1);
                if (map.containsKey(prev)) {
                    map.put(word, Math.max(map.get(prev) + 1, map.get(word)));
                }
            }
            max = Math.max(max, map.get(word));
        }

        return max;
    }

        public static void main(String[] args) {
        LongestStringChain app = new LongestStringChain();
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(app.longestStrChain(words));
    }
}
