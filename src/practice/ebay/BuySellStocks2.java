// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = prices[0];
        int sum = 0;
        int n = prices.length;

        for(int i = 1; i < n; i++) {

            if(buy > prices[i]) {
                buy = prices[i];
            }

            sum += prices[i] - buy;
            buy = prices[i];
        }
        return sum;
    }
}
