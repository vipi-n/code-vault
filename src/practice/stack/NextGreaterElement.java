package practice.stack;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;

public class NextGreaterElement {

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = nextGreater(new int[]{5,15,10,8,6,12,9,18});
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            System.out.println(m.getKey()+ " : " +m.getValue());
        }
        System.out.println("-----------------------------------");

        LinkedHashMap<Integer, Integer> map1 = nextGreater1(new int[]{5,15,10,8,6,12,9,18});
        for (Map.Entry<Integer, Integer> m : map1.entrySet()){
            System.out.println(m.getKey()+ " : " +m.getValue());
        }
    }

    // naive
    public static LinkedHashMap<Integer, Integer> nextGreater(int[] arr){
        // for maintaining insertion order
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[i] < arr[j]){
                    map.put(arr[i], arr[j]);
                    break;
                }
            }
        }
        map.put(arr[arr.length - 1], -1);
        return map;
    }

    // optimized {5,15,10,8,6,12,9,18}
    public static LinkedHashMap<Integer, Integer> nextGreater1(int[] arr){

        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        map.put(arr[arr.length - 1], -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[arr.length - 1]);

        for (int i = arr.length - 2; i >= 0; i--) {

            while (stack.peek() < arr[i] && !stack.isEmpty()){
                stack.pop();
            }
            int greater = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
            map.put(arr[i], greater);
        }
        return map;
    }
}
