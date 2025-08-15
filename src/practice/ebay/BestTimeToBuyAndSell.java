// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;
        int buy = prices[0];
        int n = prices.length;

        for(int i = 1; i < n; i++) {
           
           buy = Math.min(prices[i], buy);
           profit = Math.max(profit, prices[i] - buy);
        } 
        return profit;    
    }
}
