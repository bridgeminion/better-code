package top_interview_questions;

import java.util.*;

/**
 * use for (char c='a'; c<='z'; c++
 * convert to char array, then just set to avoid substring
 * String replace will replace all occurrence, can not use here
 * */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return count;
                }
                for (int j=0; j<word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for (char c='a'; c<='z'; c++) {
                        if (c != chars[j]) {
                            chars[j] = c;
                            String nextWord = new String(chars);
                            if (!visited.contains(nextWord) && dic.contains(nextWord)) {
                                queue.offer(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder instance = new WordLadder();
        List<String> dic = Arrays.asList("lest","leet","lose","code","lode","robe","lost");
        System.out.println(instance.ladderLength("leet", "code", dic));
    }

}
