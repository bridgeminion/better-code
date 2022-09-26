package top_interview_questions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2)-> p2[1]-p1[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[] {entry.getKey(), entry.getValue()});
        }
        for (int i=0; i<k; i++) {
            result[i] = queue.poll()[0];
        }

        return result;
    }

}
