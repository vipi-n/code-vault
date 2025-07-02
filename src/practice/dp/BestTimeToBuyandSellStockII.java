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

// 3. rec
class Solution {
    
    public int maxProfit(int[] prices) {
        
        return profit(0, prices, 1);
    }

    private int profit(int ind, int[] prices, int buy) {

        if(ind == prices.length) return 0;
        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[ind] + profit(ind + 1, prices, 0),
                     profit(ind + 1, prices, 1));
        } else {
            profit = Math.max(prices[ind] + profit(ind + 1, prices, 1),
                    profit(ind + 1, prices, 0));
        }
        return profit;
    }
}
// 4. memo
class Solution {
    
    public int maxProfit(int[] prices) {
        
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return profit(0, prices, 1, dp);
    }

    private int profit(int ind, int[] prices, int buy, int[][] dp) {

        if(ind == prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit = 0;
        
        if(buy == 1) {
            profit = Math.max(-prices[ind] + profit(ind + 1, prices, 0, dp),
                     profit(ind + 1, prices, 1, dp));
        } else {
            profit = Math.max(prices[ind] + profit(ind + 1, prices, 1, dp),
                    profit(ind + 1, prices, 0, dp));
        }
        dp[ind][buy] = profit;
        return profit;
    }
}

