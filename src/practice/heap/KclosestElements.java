package practice.heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KclosestElements {

    public static void main(String[] args) {

        int arr[] = { 10,30,5,40,38,80,70 };
        int x=35; int k = 3;
        printKClosest(arr,k,x);
    }
    private static void printKClosest(int[] arr, int k, int x) {

        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(new Pair(arr[i], Math.abs(k - arr[i])));
        }
        for (int i = k; i < arr.length; i++) {
            int diff = Math.abs(k - arr[i]);
            if (queue.peek().getValue() > diff){
                queue.poll();
                queue.offer(new Pair(arr[i], diff));
            }
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll().getKey());
        }
    }

}
class Pair
{
    Integer key;
    Integer value;

    public Pair(Integer key, Integer value)
    {
        this.key = key;
        this.value = value;
    }
    public Integer getKey()
    {
        return key;
    }
    public void setKey(Integer key)
    {
        this.key = key;
    }
    public Integer getValue()
    {
        return value;
    }
    public void setValue(Integer value)
    {
        this.value = value;
    }
}