//https://www.geeksforgeeks.org/problems/longest-common-substring1452/1


class LongestCommonSubstring {
    public int longestCommonSubstr(String s1, String s2) {
      
        int m  = s1.length();
        int n = s2.length();
        int maxLen = 0;
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }
}
