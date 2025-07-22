// https://www.naukri.com/code360/problems/ninja-s-contract_1459321?leftPanelTabValue=PROBLEM

import java.util.* ;
import java.io.*; 

// O(N * K^2)
public class PaintHouseII 
{
    public static int paintCost(int n, int k, int[][] costs) 
	{
   		int[][] dp = new int[n][k];

        for(int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }   

        for(int i = 1; i < n; i++) {
           for(int j = 0; j < k; j++) {
               int minCost = Integer.MAX_VALUE;
               dp[i][j] = costs[i][j];
               for(int l = 0; l < k; l++) {
                   if(l != j) 
                   minCost = Math.min(minCost, dp[i - 1][l]);
               }
            dp[i][j] += minCost;
           } 
        }
        int res = Integer.MAX_VALUE;
        for(int l = 0; l < k; l++) {
            res = Math.min(res, dp[n - 1][l]);
        }
        return res;
    }  
}
