package practice.sorting;

// worst TC is O(n^2) and O(n) for best case
// inplace(no use of extra space) and stable
public class InsertionSort {

    public static void main(String[] args) {

        InsertionSorting(new int[]{12,1,19,2,5});
    }

    private static void InsertionSorting(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >=0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        for (int i: arr) System.out.print( " " +i);
    }
}
