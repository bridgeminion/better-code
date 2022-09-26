package graph._1042;


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
    public int[] gardenNoAdj1(int n, int[][] paths) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] path : paths) {
            graph.putIfAbsent(path[0], new ArrayList<>());
            graph.get(path[0]).add(path[1]);
            graph.putIfAbsent(path[1], new ArrayList<>());
            graph.get(path[1]).add(path[0]);
        }
        int[] result = new int[n];
        for (int i=1; i<=n; i++) {
            if (result[i-1] == 0) {
                if (graph.get(i) == null || graph.get(i).isEmpty()) {
                    result[i-1] = 1;
                } else {
                    for (int flower= 1; flower<5; flower++) {
                            boolean conflict = false;
                            for (int g : graph.get(i)) {
                                if (result[g - 1] == flower) {
                                    conflict = true;
                                    break;
                                }
                            }
                            if (!conflict) {
                                result[i - 1] = flower;
                                break;
                            }
                    }

                }
             }
        }

        return result;
    }

    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> G = new HashMap<>();
        for (int i = 0; i < N; i++) G.put(i, new HashSet<>());
        for (int[] p : paths) {
            G.get(p[0] - 1).add(p[1] - 1);
            G.get(p[1] - 1).add(p[0] - 1);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int[] colors = new int[5];
            for (int j : G.get(i))
                colors[res[j]] = 1;
            for (int c = 4; c > 0; --c)
                if (colors[c] == 0)
                    res[i] = c;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] paths = {{7,4},{3,7},{1,5},{5,4},{7,1},{3,1},{4,3},{6,5}};
        int[][] paths = {{1,2}, {2,3}, {3,1}};
        int[] result = solution.gardenNoAdj(3, paths);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
