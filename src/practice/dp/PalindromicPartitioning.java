// https://www.geeksforgeeks.org/problems/palindromic-patitioning4845/1

class PalindromicPartitioning {
    
    static int[][] dp;
    static int palPartition(String s) {
        
        int n = s.length();
        dp = new int[n + 1][n + 1];
        
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(s, 0, n - 1);
        
    }
    
    private static int solve(String s, int i, int j) {
       
       if(i >= j) return 0;
       
       if(dp[i][j] != -1) return dp[i][j];
       
       int min = Integer.MAX_VALUE;
       
       if(isPalindrome(s, i, j)) {
           dp[i][j] = 0;
           return 0;
       }
       
       for(int k = i; k < j; k++) {
           
          int partition = 1 + solve(s, i, k) + solve(s, k + 1, j);
          min = Math.min(min, partition);

       }
        dp[i][j] = min;
       return dp[i][j];
    }
    
    private static boolean isPalindrome(String s, int i, int j) {
       
       while(i <= j) {
           if(s.charAt(i) != s.charAt(j)) {
               return false;
           }
           i++;
           j--;
       }
       return true;
    }
}

// slightly optimized but still TLE :(

// User function Template for Java

class Solution {
    
    static int[][] dp;
    static int palPartition(String s) {
        
        int n = s.length();
        dp = new int[n + 1][n + 1];
        
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(s, 0, n - 1);
        
    }
    
    private static int solve(String s, int i, int j) {
       
       if(i >= j || isPalindrome(s, i, j)) return 0;
       
       if(dp[i][j] != -1) return dp[i][j];
       
       int min = Integer.MAX_VALUE;
     
       
       for(int k = i; k < j; k++) {
           
          int leftCut = dp[i][k] != -1 ?  dp[i][k] : solve(s, i, k);
          int rightCut = dp[k + 1][j] != -1 ?  dp[k + 1][j] : solve(s, k + 1, j);
          
          int cuts = 1 + leftCut + rightCut;
          min = Math.min(min, cuts);
       }
       dp[i][j] = min;
       return dp[i][j];
    }
    
    private static boolean isPalindrome(String s, int i, int j) {
       
       while(i <= j) {
           if(s.charAt(i) != s.charAt(j)) {
               return false;
           }
           i++;
           j--;
       }
       return true;
    }
}
