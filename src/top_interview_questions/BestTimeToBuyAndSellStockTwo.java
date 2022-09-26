package top_interview_questions;

public class BestTimeToBuyAndSellStockTwo {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i=1; i<prices.length; i++) {
            profit += Math.max(prices[i] - prices[i-1], 0);
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockTwo instance = new BestTimeToBuyAndSellStockTwo();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(instance.maxProfit(prices));
    }

}
