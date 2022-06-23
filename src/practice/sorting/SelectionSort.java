package practice.sorting;

// less memory writes compare with other algorithms
// not stable, order of equal element may change
// basic idea is  find out min element and put it at 1st pos and so on..
public class SelectionSort {

    public static void main(String[] args) {

        selectionSorting(new int[]{12,1,19,2,5});
    }

    public static void selectionSorting(int[] arr){

        for (int i = 0; i < arr.length ; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        for(int i : arr) System.out.print(" " +i);
    }
}


