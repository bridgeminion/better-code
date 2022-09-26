package bfs._279;

import common.TreeNode;

import java.util.*;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class Solution {
    /**
     * Since need to find least number of perfect square, use BFS
     * Use Set<Integer> to track numbers already in queue
     * @param n
     * @return
     */
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int num = queue.poll();
                if (num == n) {
                    return count;
                }
                for (int j=1; j*j + num<= n; j++) {
                    if (!visited.contains(num + j*j)) {
                        queue.offer(num + j*j);
                        visited.add(num + j*j);
                    }
                }
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.numSquares(7168));
    }

}
