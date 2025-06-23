//https://leetcode.com/problems/longest-common-subsequence/description/

// Reccursive

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        
        return lcs(text1, text1.length(), text2, text2.length());
    }

    private int lcs(String text1, int len1, String text2, int len2) {

        if(len1 == 0 || len2 == 0) {
            return 0;
        }
        if(text1.charAt(len1 - 1) == text2.charAt(len2 - 1)) {
            return 1 + lcs(text1, len1 - 1, text2, len2 - 1);
        } else {
            return Math.max(
                lcs(text1, len1 - 1, text2, len2),
                lcs(text1, len1, text2, len2 - 1));
        }
    }

  // memeoization

  public int longestCommonSubsequence_memo(String text1, String text2) {
        
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 0; i <= len1; i++) {
            for(int j = 0; j <= len2; j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(text1, len1, text2, len2, dp);
    }

    private int lcs_memo(String text1, int len1, String text2, int len2, int[][] dp) {

        if(len1 == 0 || len2 == 0) {
            return 0;
        }
        if(dp[len1][len2] != -1) {
            return dp[len1][len2];
        }

        if(text1.charAt(len1 - 1) == text2.charAt(len2 - 1)) {
           return dp[len1][len2] =  1 + lcs(text1, len1 - 1, text2, len2 - 1, dp);
        } else {
            return dp[len1][len2] =  Math.max(
                lcs(text1, len1 - 1, text2, len2, dp),
                lcs(text1, len1, text2, len2 - 1, dp));
        }
    }

    // tabulation - bottom up
        public int longestCommonSubsequence_tabulation(String text1, String text2) {
        
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        // initialization to 0 not needed in java
        for(int i = 0; i <= len1; i++) {
             dp[i][0] = 0;
        }
        for(int j = 0; j <= len2; j++) {
                dp[0][j] = 0;
         }
        return lcs(text1, len1, text2, len2, dp);
    }

    private int lcs_tabulation(String text1, int len1, String text2, int len2, int[][] dp) {

         for(int i = 1; i <= len1; i++) {
             for(int j = 1; j <= len2; j++) {
               
            if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
         }
        }
        return dp[len1][len2];
    }
}
