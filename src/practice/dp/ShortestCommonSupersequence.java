//https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1

class ShortestCommonSupersequence {
    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        
      int m = s1.length();
       int n = s2.length();

       return m + n - lcs(s1, s2, m, n); 
    }

    private static int lcs(String str1, String str2, int m, int n) {

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
