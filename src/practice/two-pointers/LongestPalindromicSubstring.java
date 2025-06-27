// https://leetcode.com/problems/longest-palindromic-substring/description/

class Solution {
    public String longestPalindrome(String s) {
        
        String res = "";
        int resLen = 0;
        int n = s.length();

        for(int i = 0; i < n; i++) {

            // odd length palindrome
            int left = i;
            int right = i;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if(len > resLen) {
                    resLen = len;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            // even length palindrome
            left = i;
            right = i + 1;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if(len > resLen) {
                    resLen = len;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return res;
    }
}
