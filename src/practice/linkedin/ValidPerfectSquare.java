// https://leetcode.com/problems/valid-perfect-square/

class Solution {
    public boolean isPerfectSquare(int num) {

        if(num == 1) return true;
        int left = 2;
        int right = num / 2;

        while(left <= right) {
            
            int mid = (left + right) / 2;
            long square = (long) mid * mid;

            if(square == num) return true;
            else if(square < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
     
    }
}
