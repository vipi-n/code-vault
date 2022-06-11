package practice.heap;
import java.util.PriorityQueue;

public class KLargetsElements {

    public static void main(String[] args) {
        int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
        int k = 3;

        PriorityQueue<Integer> queue = firstKElements(arr, k);
        for (int i : queue){
            System.out.print( i + " ");
        }
    }

    private static PriorityQueue<Integer> firstKElements(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k ; i++) {
            queue.add(arr[i]);
        }
        for (int i = k; i < arr.length ; i++) {
            if (arr[i] > queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        return queue;
    }
}
