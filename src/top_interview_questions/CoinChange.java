package top_interview_questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * since [1,2,5] end up a lot of duplicates in queue, use visited to avoid duplicates
 *
 */
public class CoinChange {
    public int coinChangeBFS(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int coin : coins) {
            queue.offer(coin);
            visited.add(coin);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i=0; i<size; i++) {
                int sum = queue.poll();
                if (sum == amount) {
                    return count;
                }
                for (int coin : coins) {
                    if (sum + coin <= amount && !visited.contains(sum + coin)) {
                        queue.offer(sum + coin);
                        visited.add(sum + coin);
                    }
                }
            }
        }

        return -1;
    }

    /**
     * DFS + memorization
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return helper(coins, memo, amount);
    }

    private int helper(int[] coins, int[] memo, int remainder) {
        if (remainder == 0) {
            return 0;
        }
        if (remainder < 0) {
            return -1;
        }
        if (memo[remainder] != 0) {
            return memo[remainder];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = helper(coins, memo, remainder - coin) + 1;
            if (result > 0) {
                min = Math.min(min, result);
            }
        }
        memo[remainder] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[remainder];
    }

    public static void main(String[] args) {
        CoinChange instance = new CoinChange();
        int[] coins = {1,2,5};
        System.out.println(instance.coinChange(coins, 11));
    }

}
