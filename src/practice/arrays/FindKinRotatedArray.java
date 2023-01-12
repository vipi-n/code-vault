package practice.arrays;

public class FindKinRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int  target = 0;
        System.out.println(findKey(nums, target));
    }

    public static int findKey(int[] arr, int key){

        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if (arr[mid] == key) return mid;

            //means first part is sorted else second part
            if (arr[low] <= arr[mid]){
                if (arr[low] <= key && arr[mid] > key){
                    high = mid - 1;
                }else low = mid + 1;
            }else{
                if (arr[mid] <= key && arr[high] < key){
                    low = mid + 1;
                }else high = mid - 1;
            }

        }
        return -1;
    }
}
