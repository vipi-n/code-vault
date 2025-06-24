// https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383?leftPanelTabValue=PROBLEM

public class PrintLongestCommonSubsequence {
    public static String findLCS(int n, int m, String s1, String s2){

        int[][] dp = new int[n + 1][m + 1];
        lcs(n, m, s1, s2, dp);
        
        StringBuilder str = new StringBuilder();
        int i = n;
        int j = m;
        while(i > 0 && j > 0) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    str.append(s1.charAt(i - 1));
                    i--;
                    j--;
                    
                } else {
                    if(dp[i - 1][j] > dp[i][j - 1]) {
                      i--;
                    } else {
                      j--;
                    }
                }
        }
        return str.reverse().toString();
    }

    private static void lcs(int n, int m, String s1, String s2, int[][] dp) {

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

    }
}
