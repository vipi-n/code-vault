// https://leetcode.com/problems/is-subsequence/submissions/1675322899/

class Solution {
    public boolean isSubsequence(String s, String t) {

        int m = s.length();
        int n = t.length();
        int lcs = lcs(s, t, m, n);

        return lcs == s.length();
    }

    private  int lcs(String str1, String str2, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
