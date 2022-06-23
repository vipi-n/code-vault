package practice.sorting.mergesort;

public class MergeFunction {

    public static void main(String[] args) {

        int[] res = merge(new int[]{10,15,20,40,8,11,15,22,25}, 0, 8, 3);
        for (int i: res){
            System.out.print(" "+i);
        }
    }

    public static int[] merge(int[] arr, int low, int high, int mid){

        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1 ; i++) {
            left[i] = arr[i + low];
        }
        for (int i = 0; i < n2 ; i++) {
            right[i] = arr[mid + 1 + i];
        }
        int i = 0; int j =0; int k = 0;
        while (i < n1 && j < n2){
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            }else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = right[j];
            j++;
            k++;
        }
        return arr;
    }
}
