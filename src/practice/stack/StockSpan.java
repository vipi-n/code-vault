package practice.stack;

public class StockSpan {
    public static void main(String[] args) {

        int[] arr=new int[]{18,12,13,14,11,16};
        findStockSpan(arr);
        findStockSpanEfficient(arr);
    }
    // naive TC : O(n^2)
    public static void findStockSpan(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0 && arr[j] <= arr[i] ; j--) {
                span++;
            }
            System.out.println("span for " +arr[i]+ " is " +span);
        }
    }

    //efficient
    public static void findStockSpanEfficient(int arr[]){

    }

}
