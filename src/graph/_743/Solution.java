package graph._743;


import java.util.*;

/**
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 */
class Solution {
    public class Pair implements Comparable<Pair> {
        int node;
        int time;

        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Pair o) {
            return this.time - o.time;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.offer(new Pair(K, 0));
        int result = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (visited.contains(pair.node)) continue;
            visited.add(pair.node);
            N--;
            result = pair.time;
            if (graph.get(pair.node) != null) {
                for (Map.Entry<Integer, Integer> entry : graph.get(pair.node).entrySet()) {

                    queue.offer(new Pair(entry.getKey(), pair.time + entry.getValue()));
                }
            }
        }

        return N == 0 ? result : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = {{1,2,1},{2,3,2},{1,3,4}};
        System.out.println(solution.networkDelayTime(times, 3, 1));
    }
}
