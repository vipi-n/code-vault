package practice.arrays;

public class MaxCircularSumEfficient {

    public static void main(String[] args) {

        int arr[] = {5, -2, 3, 4}, n = 4;
        System.out.println(OverallMaxSum(arr));

    }

    private static int  maxNormalSum(int[] arr) {

        int result = arr[0];
        int maxEnding = arr[0];

        for (int i = 1; i < arr.length ; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            result = Math.max(result, maxEnding);
        }
        return result;
    }
    private static int  OverallMaxSum(int[] arr) {
        int maxNormalSum = maxNormalSum(arr);
        if (maxNormalSum < 0) return maxNormalSum;

        int arrSum = 0;
        for (int i = 0; i < arr.length ; i++) {
            arrSum += arr[i];
            arr[i] = -arr[i];
        }
        int maxCircularSum = maxNormalSum(arr) + arrSum;
        return Math.max(maxCircularSum, maxNormalSum);
    }



}
