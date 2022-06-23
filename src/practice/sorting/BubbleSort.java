package practice.sorting;

// TC O(n^2)
// if sorted then O(n) with swapped variable
// stable sorting ie. it'll not change the position of the element
public class BubbleSort {

    public static void main(String[] args) {

        bubbleSorting(new int[]{12,1,19,2,5});
        //bubbleSorting(new int[]{1,2,3,4,5,6});
    }

    public static void bubbleSorting(int[] arr){

        for (int i = 0; i < arr.length - 1 ; i++) {
            boolean swapped = false;
            for (int j = i ; j < arr.length - 1 - i ; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        for (int i : arr){
            System.out.print(" " +i);
        }
    }
}
