// https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1


class LongestRepeatingSubsequence {
    public int longestRepeatingSubsequence(String s) {       
       return  lcs(s, s);
    }
    
    private int lcs(String s1, String s2) {
        
        int m = s1.length();
        int n = n;
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
            
            if(s1.charAt(i -1) == s2.charAt(j - 1) && i != j) {    
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
