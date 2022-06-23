package practice.arrays;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {

        union1(new int[]{1,2,2,3,4}, new int[]{2,3,5,6});
    }

    // intersection
    public static void intersection(int[] arr1, int[] arr2){

        Set<Integer> set = new HashSet<>();

        for (int i : arr1) set.add(i);
        for (int i : arr2){
            if (!set.add(i)) System.out.println(i);
        }
    }
    //union -- we can use hashmap as well, add element as key
    public static void union(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) set.add(i);
        for (int i : arr2){
            set.add(i);
        }
        System.out.println(set);
    }
    public static void union1(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();
        int size = Math.min(arr1.length, arr2.length);

        for (int i = 0; i < size ; i++) {
            set.add(arr1[i]);
            set.add(arr2[i]);
        }
        if (size < arr1.length){
            for(int i : arr1) set.add(i);
        }else if (size < arr2.length){
            for(int i : arr2) set.add(i);
        }
        System.out.println(set);
    }
}
