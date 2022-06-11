package practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class Frequency {

    public static void main(String[] args) {
        freq(new int[]{1,2,1,2,2,3,4,4,3});
    }

    public static  void freq(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length ; i++) {
             map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            System.out.println("key : " +m.getKey()+ " value : " +m.getValue());
        }
    }
}
