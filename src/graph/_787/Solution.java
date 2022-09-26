package graph._787;

import java.util.*;

/**
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        priorityQueue.offer(new int[]{0, src, K+1});
        while (!priorityQueue.isEmpty()) {
            int[] item = priorityQueue.poll();
            int cost = item[0];
            int city = item[1];
            int stopLeft = item[2];
            if (city == dst) {
                return cost ;
            }
            if (stopLeft > 0) {
                if (!graph.containsKey(city)) {
                    continue;
                }
                for (int[] i : graph.get(city)) {
                    priorityQueue.offer(new int[]{cost + i[1], i[0], stopLeft - 1});
                }
            }
        }

        return -1;
    }

    public int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        int answer = Integer.MAX_VALUE;
        int stop = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] city = queue.poll();
                if (city[0] == dst) {
                    answer = Math.min(answer, city[1]);
                }
                if (graph.containsKey(city[0])) {
                    for (int[] next : graph.get(city[0])) {
                        if (next[1] + city[1] < answer) {
                            queue.offer(new int[]{next[0], next[1] + city[1]});
                        }
                    }
                }
            }
            if (stop++ > K) {
                break;
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    int answer = Integer.MAX_VALUE;
    public int findCheapestPriceDFS(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        dfs(graph, dst, K, 0, src, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(Map<Integer, List<int[]>> graph, int dst, int k, int stops, int current, int cost) {
        if (current == dst) {
            answer = Math.min(answer, cost);
            return;
        }
        if (stops <= k) {
            if (graph.containsKey(current)) {
                for (int[] next : graph.get(current)) {
                    if (next[1] + cost < answer) {
                        dfs(graph, dst, k, stops + 1, next[0], next[1] + cost);
                    }
                }
            }
        }
    }


}
