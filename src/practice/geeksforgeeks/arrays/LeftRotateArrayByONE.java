package practice.geeksforgeeks.arrays;

public class LeftRotateArrayByONE {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int[] res = leftRotate(nums, 1);
        for (int i : res){
            System.out.print( " " +i);
        }
    }
    public static int[] leftRotate(int[] arr, int k){
        int temp = arr[k-1];
        int i;
        for (i = k; i < arr.length ; i++) {
            arr[i - 1] = arr[i];
        }
        arr[i - 1] = temp;
        return arr;
    }

}
