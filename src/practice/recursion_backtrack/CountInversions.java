// https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
// TC O(nlogn), SC O(n)

class Solution {
    static int inversionCount(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        return mergeSortFunc(arr, low, high);   
    }

    public static int mergeSortFunc(int[] arr, int low, int high) {

        int count = 0;
        if(low >= high) return 0;
        int mid = (low + high) / 2;

        count += mergeSortFunc(arr, low, mid);
        count += mergeSortFunc(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
       
        int count = 0;
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
                count += (mid - left) + 1;
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
        return count;
        
    }
}
