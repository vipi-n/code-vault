//BestTimeToBuyandSellStockII

// 1.
class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = prices[0];
        int n = prices.length;
        int maxProfit = 0;

        for(int i = 1; i < n; i++) {
            
            if(buy > prices[i]) {
                buy = prices[i];
            }
            maxProfit += prices[i] - buy;
            buy = prices[i];
        }
        return maxProfit;
    }
}

// 2.
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {

            if(prices[i - 1] < prices[i]) {
                int profit = prices[i] - prices[i - 1]; 
                maxProfit += profit;       
            }
        }
        return maxProfit;
    }
}
