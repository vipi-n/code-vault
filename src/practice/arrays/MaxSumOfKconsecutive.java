package practice.arrays;

/**
 * given an array of integer and a number k, find the max sum of k consecutive elements
 * sliding window problem
 */
public class MaxSumOfKconsecutive {
    public static void main(String[] args) {
        int[] arr = {1,8,30,-5,20,7}; int k = 3;
        System.out.println(maxSumOfConsecutiveElements(arr, k));
    }
    public static int maxSumOfConsecutiveElements(int[] arr, int k){
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }
        int maxSum = currSum;
        for (int i = k; i < arr.length; i++) {
            currSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
