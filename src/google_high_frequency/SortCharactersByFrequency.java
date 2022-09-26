package google_high_frequency;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySortWithBucketSort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new List[s.length()];
        int maxIndex = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
            maxIndex = Math.max(maxIndex, entry.getValue());
        }
        StringBuilder sb = new StringBuilder();
        for (int i=maxIndex; i>=0 ; i--) {
            if (bucket[i] != null) {
                for (int k=0; k<bucket[i].size(); k++) {
                    for (int j=0; j<i; j++) {
                        sb.append(bucket[i].get(k));
                    }
                }
            }
        }

        return sb.toString();
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        queue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i=0; i<entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        SortCharactersByFrequency app = new SortCharactersByFrequency();
        System.out.println(app.frequencySort("Aabb"));
    }

}
