package google_high_frequency;

import java.util.*;

public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : map.keySet()) {
            pq.offer(c);
        }
        while (!pq.isEmpty()) {
            char c = pq.poll();
            sb.append(c);
            map.put(c, map.get(c) - 1);
            queue.offer(c);
            if (queue.size() < k) {
                continue;
            }
            char prev = queue.poll();
            if (map.get(prev) > 0) {
                pq.offer(prev);
            }
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        RearrangeStringKDistanceApart app = new RearrangeStringKDistanceApart();
        System.out.println(app.rearrangeString("aabbcc", 3));
    }
}
