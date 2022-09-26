package google_high_frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input: [[0,1,10],[2,0,5]]
 * Output: 2
 * Explanation:
 * Two edges are need to added. There are [1,0,5] and [1,2,5]
 */
public class OptimalAccountBalancing {
    int min = Integer.MAX_VALUE;
    public int balanceGraph(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], 0) + edge[2]);
            map.put(edge[1], map.getOrDefault(edge[1], 0) - edge[2]);
        }
        List<Integer> list = new ArrayList<>();
        for (int value : map.values()) {
            if (value != 0) {
                list.add(value);
            }
        }
        dfs(list, 0, 0);

        return 0;
    }

    private void dfs(List<Integer> list, int index, int count) {
        if (index == list.size()) {
            min = Math.min(min, count);
            return;
        }

    }

}
