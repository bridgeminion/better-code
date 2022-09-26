package graph._1129;


import java.util.*;

/**
 * You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].
 *
 * Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.
 *
 * If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.*
 *
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * Output: 0.25000
 * Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
 */
class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, Set<Integer>> redGraph = new HashMap<>();
        Map<Integer, Set<Integer>> blueGraph = new HashMap<>();
        for (int i=0; i<n; i++) {
            redGraph.put(i, new HashSet<>());
            blueGraph.put(i, new HashSet<>());
        }
        for(int[] edge : red_edges) {
            redGraph.get(edge[0]).add(edge[1]);
        }
        for(int[] edge : blue_edges) {
            blueGraph.get(edge[0]).add(edge[1]);
        }
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            result[i] = -1;
        }
        shortestPath(redGraph, blueGraph, result);
        return result;
    }

    private void shortestPath(Map<Integer, Set<Integer>> redGraph, Map<Integer, Set<Integer>> blueGraph, int[] result) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        visited.add(0 + "0");
        visited.add(0 + "1");
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] node = queue.poll();
                if (result[node[0]] == -1) {
                    result[node[0]] = level;
                }
                if (node[1] == 0 ) { // from red
                    for (int bn : blueGraph.get(node[0])) {
                        if (!visited.contains(bn + "1")) {
                            queue.offer(new int[] {bn, 1});
                            visited.add(bn + "1");
                        }
                    }
                } else if (node[1] == 1 ) {
                    for (int bn : redGraph.get(node[0])) {
                        if (!visited.contains(bn + "0")) {
                            queue.offer(new int[] {bn, 0});
                            visited.add(bn + "0");
                        }
                    }
                }

            }
            level++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] red = {{0,1},{0,2}};
        int[][] blue = {{1,0}};
        int[] result = solution.shortestAlternatingPaths(3, red, blue);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
