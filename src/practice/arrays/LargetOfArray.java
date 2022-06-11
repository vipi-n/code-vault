package practice.arrays;

public class LargetOfArray {

    public static void main(String[] args) {
        int[] nums = {1,2,8,4,5};
        int x = 3;
        int size = largest(nums);
        System.out.println(size);
    }
    public static int largest(int[] arr){

        int max = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
}
