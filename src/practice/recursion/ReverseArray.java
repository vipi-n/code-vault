// https://www.naukri.com/code360/problems/reverse-an-array_8365444?leftPanelTabValue=PROBLEM

public class Solution {
    public static int[] reverseArray(int n, int []nums) {
       
       int i = 0;
       int j = n - 1;

       while (i <= j) {
           int temp = nums[i];
           nums[i] = nums[j];
           nums[j] =temp;
           i++;
           j--;
       }
       return nums;
    }
}
