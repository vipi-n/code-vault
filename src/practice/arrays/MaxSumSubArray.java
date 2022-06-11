package practice.arrays;

public class MaxSumSubArray {

    public static void main(String[] args) {

        int[] arr = {1, -2, 3, -1, 2,3,5};
        System.out.println(maxSum2(arr));
    }

    static int maxSum(int[] arr){

        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {

            sum += arr[i];
            if (sum < 0){
                sum = 0;
            }
        }
        return sum;
    }

    //2nd
    static int maxSum1(int[] arr){

        int res = 0;
        for (int i = 0; i < arr.length ; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length ; j++) {
               currSum += arr[j];
                res = Math.max(res, currSum);
            }
        }
        return res;
    }

    //3rd
    static int maxSum2(int[] arr){

        int res = arr[0];
        int preMaxSum = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            preMaxSum = Math.max(preMaxSum + arr[i], arr[i]);
            res = Math.max(res, preMaxSum);
        }
        return res;
    }
}
