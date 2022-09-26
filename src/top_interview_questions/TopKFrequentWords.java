package top_interview_questions;

import java.util.*;

public class TopKFrequentWords {
    class Entry implements Comparable<Entry> {
        String word;
        int count;

        public Entry (String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Entry o) {
            if (count == o.count) {
                return word.compareTo(o.word);
            }
            return count - o.count;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String key : map.keySet()) {
            pq.offer(new Entry(key, map.get(key)));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().word);
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentWords app = new TopKFrequentWords();
        String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(app.topKFrequent(words, 2));
    }
}
