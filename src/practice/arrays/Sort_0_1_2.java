package practice.arrays;
import java.util.Arrays;

public class Sort_0_1_2 {

    public static void main(String[] args) {
        int[] arr = {0,1,2,1,0,2,1};
        sort2(arr);
        System.out.println("-------------------------------");

    }

    private static void sort2(int[] arr){

        int low = 0;
        int high = arr.length - 1;
        int index = 0;

        while (index <= high && low < high){
            if (arr[index] == 0){
                arr[index] = arr[low];
                arr[low] =0;
                low++;
                index++;
            }else if (arr[index] == 1){
                index++;
            }else {
                arr[index] = arr[high];
                arr[high] = 2;
                high--;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int[] arr) {

        int size0 = 0;
        int size1= 0;
        for (int i : arr){
            if (i == 0) size0++;
            else if(i == 1)size1++;
        }
        for (int i = 0; i < size0 ; i++) {
            arr[i] = 0;
        }
        for (int i = size0; i < size0 + size1 ; i++) {
            arr[i] = 1;
        }
        for (int i = size0 + size1; i < arr.length ; i++) {
            arr[i] = 2;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort1(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid < high){
            switch (arr[mid]){
                case 0:
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp1 = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp1;
                    mid++;
                    high--;
                    break;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
