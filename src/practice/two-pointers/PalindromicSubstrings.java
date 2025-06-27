// https://leetcode.com/problems/palindromic-substrings/

class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        int count = 0;

        for(int i = 0; i < n; i++) {

            // odd length palindrome
            int left = i;
            int right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }

            // even length palindrome
            left = i;
            right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
        }
        return count;
    }
}
    
