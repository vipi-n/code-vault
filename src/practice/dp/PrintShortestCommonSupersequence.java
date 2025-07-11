// https://leetcode.com/problems/shortest-common-supersequence/description/

class PrintShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {

       if (str1.equals(str2)) return str1;
       int m = str1.length();
       int n = str2.length();
       
       int i = m;
       int j = n;
       StringBuilder str = new StringBuilder();

       int[][] dp = lcs(str1, str2, m, n);

       while(i > 0 && j > 0) {

        if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
            str.append(str1.charAt(i - 1));
            i--;
            j--;
        } else {
            if(dp[i - 1][j] > dp[i][j - 1]) {
                str.append(str1.charAt(i - 1));
                i--;
            } else {
                str.append(str2.charAt(j - 1));
                j--;
            }
        }
       }

       while(i > 0) {
        str.append(str1.charAt(i - 1));
        i--;
       }
        while(j > 0) {
        str.append(str2.charAt(j - 1));
        j--;
       }

       return str.reverse().toString();
    }

    private  int[][] lcs(String str1, String str2, int m, int n) {

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
        return dp;
    }
}
