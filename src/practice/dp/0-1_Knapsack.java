// https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

// 1. Recursion

class Solution {

    static int knapsack(int W, int val[], int wt[]) {
        return knapsack01(W, val, wt, val.length);
    }

    private static int knapsack01(int W, int val[], int wt[], int n) {
        //if no capacity or no items left
        if (W == 0 || n == 0) {
            return 0;
        }

        // If current item can be included, the we can add this or not add this depends on us
        if (W >= wt[n - 1]) {
            return Math.max(
                val[n - 1] + knapsack01(W - wt[n - 1], val, wt, n - 1),
                knapsack01(W, val, wt, n - 1)
            );
        } else {
            // If current item cannot be included, we cannot add this in the bag
            return knapsack01(W, val, wt, n - 1);
        }
    }
}
    // 2. Memoization (top down)
class Solution_Memoization {

    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[W + 1][n + 1];
        
        for (int i = 0; i <= W; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return knapsack01(W, val, wt, n, dp);
    }

    private static int knapsack01(int W, int val[], int wt[], int n, int[][] dp) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[W][n] != -1) {
            return dp[W][n];
        }

        if (W >= wt[n - 1]) {
            return dp[W][n] = Math.max(
                val[n - 1] + knapsack01(W - wt[n - 1], val, wt, n - 1, dp),
                knapsack01(W, val, wt, n - 1, dp)
            );
        } else {
            return dp[W][n] = knapsack01(W, val, wt, n - 1, dp);
        }
    }
}

// bottom-up 
class Solution {
    
    static int knapsack(int W, int val[], int wt[]) {
       
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        // in the first row and column we need to put 0, by default it will be 0 in java 
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                
                if(j >= wt[i - 1]) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]],
                                dp[i - 1][j]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
       }
        return dp[n][W];
    }
}




