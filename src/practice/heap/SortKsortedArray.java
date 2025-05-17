package practice.heap;
// https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
import java.util.PriorityQueue;

public class SortKsortedArray {

    public static void main(String[] args) {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        int[] res = sortK(arr, k);
        for (int i : res){
            System.out.print(i + " ");
        }

        
    }
    public static int[] sortK(int[] arr, int k){

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <= k ; i++) {
            queue.add(arr[i]);
        }
        int index = 0;
        for (int i = k + 1; i < arr.length ; i++) {
            arr[index++] = queue.peek();
            queue.poll();
            queue.add(arr[i]);
        }
        while (!queue.isEmpty()){
            arr[index++] = queue.poll();
        }
        return arr;
    } 
}
