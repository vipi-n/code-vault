package practice.geeksforgeeks;

public class LeftRotatebyK {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6};
        int[] res = leftRotate(nums, 3);
        for (int i : res){
            System.out.print(" " +i);
        }
    }

    public static int[] leftRotate(int[] arr, int k){
        // with O(n) space
/*        int[] temp = new int[arr.length];
        int j = 0;
        for (int i = k ; i < arr.length ; i++) {
            temp[j] = arr[i];
            j++;
        }
        for (int i = 0; i < k ; i++) {
            temp[j] = arr[i];
            j++;
        }
        return temp;*/
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        return arr;
    }
       static void reverse(int[] arr, int low, int high){
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high]  = temp;
            low++;
            high--;
        }
       }
}
