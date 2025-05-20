// https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int i = 0;
        int j = str.length() - 1;

        while(i <= j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
         return true;
    }
}
