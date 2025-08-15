// https://leetcode.com/problems/alternating-digit-sum/description/
class Solution {
    public int alternateDigitSum(int n) {

       int sum = 0;
       String str = String.valueOf(n);

       for(int i = 0; i < str.length(); i++) {

        int digit = str.charAt(i) - '0';
        
        if(i % 2 == 0) {
            sum += digit;
        } else {
            sum -= digit;
        }
       }
       return sum;
    }
}
