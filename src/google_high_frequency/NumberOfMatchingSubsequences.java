package google_high_frequency;

import java.util.*;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq1   (String S, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<String>());
        }
        for (String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }

    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<String>> map = new HashMap<>();
        for (String word : words) {
            map.putIfAbsent(word.charAt(0), new ArrayList<>());
            map.get(word.charAt(0)).add(word);
        }
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                List<String> matches = map.get(c);
                map.remove(c);
                for (String match : matches) {
                    if (match.length() == 1) {
                        count++;
                    } else {
                        map.putIfAbsent(match.charAt(1), new ArrayList<>());
                        map.get(match.charAt(1)).add(match.substring(1));
                    }
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        NumberOfMatchingSubsequences app = new NumberOfMatchingSubsequences();
        String[] words = {"qlhxagxdq","qlhxagxdq","lhyiftwtut","yfzwraahab"};
        System.out.println(app.numMatchingSubseq("qlhxagxdqh", words));
    }
}
