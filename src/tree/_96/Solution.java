package tree._96;

/**
 * 96. Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Solution {
    /**
     * dp[n] = dp[0]*dp[n-1] + dp[1]*dp[n-2] +...+ dp[n-1]*dp[0]
     * Need to populate dp[0]...dp[n]
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int numOfNodes = 1; numOfNodes <= n; numOfNodes++) {
            for (int root = 1; root <= numOfNodes; root++) {
                dp[numOfNodes] += dp[root-1]*dp[numOfNodes-root];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
