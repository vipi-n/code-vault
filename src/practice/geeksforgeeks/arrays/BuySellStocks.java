package practice.geeksforgeeks.arrays;

public class BuySellStocks {

    public static void main(String[] args) {

        int arr[] = {1,5,3,8,12};
        int maxProfit = buySell(arr, 0, 4);
        System.out.println(maxProfit);
    }
    public static int buySell(int[] arr, int start, int end){

        int maxProfit = 0;

        for (int i = start; i < end ; i++) {
            for (int j = i+1; j <= end ; j++) {

                if (arr[i] < arr[j]){
                    int currProfit = arr[j] - arr[i] + buySell(arr, start, i-1) + buySell(arr, j + 1, end);
                    maxProfit = Math.max(maxProfit, currProfit);
                }
            }
        }
        return maxProfit;

    }
}
