https://www.geeksforgeeks.org/problems/maximum-sum-of-subarray-less-than-or-equal-to-x4033/1

class MaxSubarraySumUnderX {
    public long findMaxSubarraySum(int[] arr, long x) {
        // Your code goes here
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxSum = 0;
        int n = arr.length;
        
        while(j < n) {
            sum += arr[j];
            
            while(sum > x) {
                sum = sum - arr[i];
                i++;
            }
            if(sum <= x) {
                maxSum = Math.max(maxSum, sum);
            }
            j++;
        }
        return maxSum;
    }
}
