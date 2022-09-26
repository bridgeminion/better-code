package by_frequency_and_tag.backtracking;

import java.util.*;

public class WordLadderTwo {
    class Entry {
        String w;
        List<String> path;
        public Entry (String w, List<String> path) {
            this.w = w;
            this.path = path;
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        List<List<String>> result = new ArrayList<>();
        Queue<Entry> queue = new LinkedList<>();
        List<String> pl = new ArrayList<>();
        pl.add(beginWord);
        queue.offer(new Entry(beginWord, pl));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean stop = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Entry w = queue.poll();
                List<String> path = w.path;
                List<String> words = findNext(w.w, set);
                for (String word : words) {
                    if (word.equals(endWord)) {
                        List<String> clone = new ArrayList(path);
                        clone.add(word);
                        result.add(clone);
                        stop = true;
                    } else if (visited.add(word)) {
                        List<String> clone = new ArrayList(path);
                        clone.add(word);
                        queue.offer(new Entry(word, clone));
                    }
                }
            }
            if (stop) {
                return result;
            }
        }
        return result;
    }

    private List<String> findNext(String word, Set<String> set) {
        List<String> result = new ArrayList<>();
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            for (int j=0; j<26; j++) {
                char newC = (char)('a' + j);
                if (newC != c) {
                    String newWord = word.substring(0, i) + newC + word.substring(i+1);
                    if (set.contains(newWord)) {
                        result.add(newWord);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        WordLadderTwo app = new WordLadderTwo();
        List<String> wordList = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        System.out.println(app.findLadders("red", "tax", wordList));
    }
}
