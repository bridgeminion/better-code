package fb_high_frequency;

import common.UnionFind;

import java.util.Arrays;

/**
 * There are N cities numbered from 1 to N.
 *
 * You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect
 * city1 and city2together.  (A connection is bidirectional: connecting city1 and city2 is the same as
 * connecting city2 and city1.)
 *
 * Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1)
 * that connects those two cities together.  The cost is the sum of the connection costs used.
 * If the task is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation:
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * Example 2:
 *
 *
 *
 * Input: N = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation:
 * There is no way to connect all cities even if all edges are used.
 * Note:
 *
 * 1 <= N <= 10000
 * 1 <= connections.length <= 10000
 * 1 <= connections[i][0], connections[i][1] <= N
 * 0 <= connections[i][2] <= 10^5
 * connections[i][0] != connections[i][1]
 */
public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(N);
        int cost = 0;
        for (int[] connection : connections) {
            if (uf.find(connection[0]) != uf.find(connection[1])) {
                uf.union(connection[0], connection[1]);
                cost += connection[2];
            }
            if (uf.getCount() == 1) {
                return cost;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCost app = new ConnectingCitiesWithMinimumCost();
//        int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
//        System.out.println(app.minimumCost(3, connections));
        int[][] connections = {{1,2,3},{3,4,4}};
        System.out.println(app.minimumCost(4, connections));
    }
}
