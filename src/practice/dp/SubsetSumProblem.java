// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

// Recursive(TC : 2^n)

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        return isSubset(arr, sum, arr.length - 1);
        
    }
    
    private static boolean isSubset(int arr[], int sum, int n) {
        
        if(sum == 0){
            return true;
        }
        if(n == 0) {
            return arr[n] == sum; // if it came to 0 and that number is same as sum then true else false
        }
        boolean notTake = isSubset(arr, sum, n - 1);
        boolean take = isSubset(arr, sum - arr[n], n - 1);
        
        return notTake || take;
    }

    // Memoization

        static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        
         for (int row[] : dp)
            Arrays.fill(row, -1);
        
        return isSubset(arr, sum, n - 1, dp);
        
    }
    
    private static boolean isSubset(int arr[], int sum, int n, int[][] dp) {
        
        if(sum == 0){
            return true;
        }
        
        if(n == 0) {
            return arr[n] == sum;
        }
        
        if(dp[n][sum] != -1) {
            return dp[n][sum] != 0 ? true : false;
        }
        
        boolean notTake = isSubset(arr, sum, n - 1, dp);
        boolean take = false;
        if (arr[n] <= sum)
            take = isSubset(arr, sum - arr[n], n - 1, dp);
            
        dp[n][sum] =  notTake || take == true ? 1 : 0;   
        
        return notTake || take;
        
    }
}
