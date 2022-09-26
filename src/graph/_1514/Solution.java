package graph._1514;


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
    class Pair implements Comparable<Pair> {
        int fst;
        double snd;

        public Pair(int fst, double snd) {
            this.fst = fst;
            this.snd = snd;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(o.snd, this.snd); // max queue
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i=0; i<succProb.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new Pair(start, 1.0));
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            if (visited.contains(node.fst)) continue;
            visited.add(node.fst);
            if (node.fst == end) {
                return node.snd;
            }
            if (graph.get(node.fst) != null) {
                for (Pair neighbor : graph.get(node.fst)) {
                    if (!visited.contains(neighbor.fst)) {
                        queue.offer(new Pair(neighbor.fst, neighbor.snd * node.snd));
                    }
                }
            }
        }

        return 0.00000;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}};
        double[] prob = {0.37,0.17,0.93,0.23,0.39,0.04};
        Solution solution = new Solution();
        System.out.println(solution.maxProbability(5, edges, prob, 3, 4));
//        int[][] edges = {{0,1}};
//        double[] prob = {0.5};
//        Main solution = new Main();
//        System.out.println(solution.maxProbability(3, edges, prob, 0, 2));
    }
}
