package practice.geeksforgeeks.arrays;

public class BuySellSticksEfficient {

    public static void main(String[] args) {

        int arr[] = {7,1,5,3,6,4};
        int maxProfit = buySell(arr, 0, 4);
        System.out.println(maxProfit);
    }
    public static int buySell(int[] arr, int start, int end){

        int profit = 0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] > arr[i - 1]){
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }
}
