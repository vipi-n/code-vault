package practice.arrays;

/**
 * find the subArray with given sum of size k
 * sliding window
 */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1,8,30,-5,20,7}; int k = 3; int sum = 45;
        System.out.println(findSubArray(arr, k, sum));
    }

    private static boolean findSubArray(int[] arr, int k, int sum) {
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }
        if (currSum == sum) return true;
        for (int i = k; i < arr.length ; i++) {
            currSum += arr[i] - arr[i - k];
            if (currSum == sum) return true;
        }
        return false;
    }
}
