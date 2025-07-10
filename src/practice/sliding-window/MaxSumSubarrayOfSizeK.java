// https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

public class MaxSumSubarrayOfSizeK {
    public int maximumSumSubarray(int[] arr, int k) {
      
        int n = arr.length;
        int currentSum = 0;


        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        int maxSum = currentSum;

        // Slide the window
        for (int i = k; i < n; i++) {
            currentSum = currentSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

  // OR
   public int maximumSumSubarray(int[] arr, int k) {
        
        int n = arr.length;
        int maxSum = 0;
        
        for(int temp = 0; temp < k; temp++) {
            maxSum += arr[temp];
        }
        
        int i = 0;
        int j = k;
        int windowSum = maxSum;
        
        while(j < n) {
          
          windowSum = windowSum - arr[i] + arr[j];
          maxSum = Math.max(maxSum, windowSum);
          j++;
          i++;
            
        }
        return maxSum;
    }

  //OR

  public int maximumSumSubarray(int[] arr, int k) {
        
        int n = arr.length;
       
        int i = 0;
        int j = 0;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        while(j < n) {
          
          windowSum += arr[j];
          
          if(j - i + 1 == k) {
               maxSum = Math.max(maxSum, windowSum);
               windowSum = windowSum - arr[i];
               j++;
               i++;
          } else {
              j++;
          }
         
        }
        return maxSum;
    }
}
