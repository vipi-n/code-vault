//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

class MinimumInsertionStepstoMakeAStringPalindrome {
    public int minInsertions(String s) {
        
        String s1 = new StringBuilder(s).reverse().toString();

        if(s1.equals(s)) return 0;
        // we find the lps, why because ques is we need to find out min insertion to make the string palindrome, so if we find out lps that means this
        // is the longest subsequence where the insertion/deletion were min. no. of deletion/insertion is inversely proportional to the lps
        return s.length() - longestPalendromicSubSeq(s, s1);
    }

    private int longestPalendromicSubSeq(String s, String s1) {
        int m = s.length();
        int n = s1.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if(s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i -1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

