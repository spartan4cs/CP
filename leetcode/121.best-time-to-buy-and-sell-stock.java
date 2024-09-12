/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int minbuy = Integer.MAX_VALUE;
        int maxprofit = 0;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {

            minbuy = Math.min(minbuy, prices[i]);
            profit = prices[i] - minbuy;
            maxprofit = Math.max(maxprofit, profit);

        }
        return maxprofit;

    }
}
// @lc code=end
