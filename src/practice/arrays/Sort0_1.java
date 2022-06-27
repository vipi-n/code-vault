package practice.arrays;

import java.util.Arrays;

public class Sort0_1 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,0,0,1};
        sort(arr);
        System.out.println("-------------------------------");
        sort1(arr);
    }

    public static void sort(int[] arr){
        int size = 0;
        for(int i :  arr){
            if (i == 0) size++;
        }
        for (int i = 0; i < size ; i++) {
            arr[i] = 0;
        }
        for (int i = size; i < arr.length ; i++) {
            arr[i] = 1;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void sort1(int[] arr){

        int low = 0;
        int high = arr.length - 1;

        while (low < high){

            while(low < high && arr[low] == 0){
                low++;
            }
            while (low < high && arr[high] == 1){
                high--;
            }
            if (low < high){
                arr[low] = 0;
                arr[high] = 1;
                low++;
                high--;
            }
        }

        Arrays.stream(arr).forEach(System.out::println);
    }

}
