// https://www.naukri.com/code360/problems/frog-jump_3621012

public class Solution {

  // rec
    public static int frogJump(int n, int heights[]) {

        return helper(n - 1, heights);  
    }
    private static int helper(int n, int heights[]) {

        if(n == 0) return 0;
        if(n == 1) return  Math.abs(heights[0] - heights[1]);

        int firstJump = helper(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int secondJump = 0;
        if(n > 1)
        secondJump = helper(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        return Math.min(firstJump, secondJump);

    }

  // memo

  public static int frogJump(int n, int heights[]) {

        int[] dp = new int[n];
        Arrays.fill(dp,  -1);
        return helper(n - 1, heights, dp);  
    }

    private static int helper(int n, int heights[], int[] dp) {

        if(n == 0) return 0;
        if(n == 1) return  Math.abs(heights[0] - heights[1]);

        if(dp[n] != -1) return dp[n];

        int firstJump = helper(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int secondJump = 0;
        if(n > 1)
        secondJump = helper(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        return  dp[n] = Math.min(firstJump, secondJump);

    }

  // bottom-up
  public static int frogJump(int n, int heights[]) {
        
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i = 1; i < n; i++) {
        
        int firstJump = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
        int secondJump = Integer.MAX_VALUE;
        if(i > 1)
        secondJump = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
        dp[i] = Math.min(firstJump, secondJump);

        }
        return dp[n - 1];
       
    }

  // space optimazation

  public static int frogJump(int n, int heights[]) {
        
        int prev = 0;
        int prev2= 0;
        
        for(int i = 1; i < n; i++) {
        
        int firstJump = prev + Math.abs(heights[i] - heights[i - 1]);
        int secondJump = Integer.MAX_VALUE;
        if(i > 1)
        secondJump = prev2 + Math.abs(heights[i] - heights[i - 2]);
        int curr = Math.min(firstJump, secondJump);
        prev2 = prev;
        prev = curr;

        }
        return prev;
       
    }

}
