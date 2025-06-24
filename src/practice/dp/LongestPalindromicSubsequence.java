//https://leetcode.com/problems/longest-palindromic-subsequence/description/

class Solution {
    public int longestPalindromeSubseq(String s) {

        String s1 = new StringBuilder(s).reverse().toString();
        int m  = s.length();
        return lcs(s, s1, m, m);
    }

    private int lcs(String s1, String s2, int m, int n) {

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j<= n; j++) {

                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

