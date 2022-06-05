package practice.geeksforgeeks.arrays;

public class MaxCircularSum {

    public static void main(String[] args) {

        int arr[] = {5, -2, 3, 4}, n = 4;

        System.out.println(maxSum(arr));

    }

    public static int maxSum(int[] arr){

        int res = arr[0];
        for (int i = 0; i < arr.length ; i++) {

            int currSum = arr[i];
            int currMax = arr[i];

            for (int j = 1; j < arr.length ; j++) {
                int index = (i+j)%arr.length;
                currSum += arr[index];
                currMax = Math.max(currMax, currSum);


            }
            res = Math.max(res, currMax);
        }
        return res;
    }
}
