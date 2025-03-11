// https://leetcode.com/problems/longest-common-subsequence/
//LTE
class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        
        return lcs(text1, text2, text1.length() - 1, text2.length() - 1);

    }

    public int lcs(String text1, String text2, int len1, int len2) {

        if(len1 < 0 || len2 < 0) {
            return 0;
        }
        if(text1.charAt(len1) == text2.charAt(len2)) {
            return 1 + lcs(text1, text2, len1 - 1,len2 - 1);
        } else {
            return Math.max(lcs(text1, text2, len1 - 1,len2) ,
                           lcs(text1, text2, len1,len2 - 1));
        }
    }
}
