// https://www.naukri.com/code360/problems/merge-sort_920442?leftPanelTabValue=PROBLEM
public class Solution {
    public static void mergeSort(int[] arr, int n) {

        int low = 0;
        int high = n - 1;
        mergeSortFunc(arr, low, high);
    }

    public static void mergeSortFunc(int[] arr, int low, int high) {

        if(low >= high) return;
        int mid = (low + high) / 2;

        mergeSortFunc(arr, low, mid);
        mergeSortFunc(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        // [low, mid] + [mid + 1, high]
        int left = low;
        int right = mid + 1;
        int k = 0;
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[k] = arr[left];
                k++;
                left++;
            } else {
                temp[k] = arr[right];
                k++;
                right++;
            }
        }

        while(left <= mid) {
            temp[k] = arr[left];
            k++;
            left++;
        }
        while(right <= high) {
            temp[k] = arr[right];
            k++;
            right++;
        }
        for(int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
        
    }
}
