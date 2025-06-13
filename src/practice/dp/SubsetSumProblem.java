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
}
