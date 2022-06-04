package practice.geeksforgeeks.arrays;

public class MaxDiff {

    public static void main(String[] args) {

        int[] arr = new int[]{1,18,10,0};
        int res = maxDiff(arr);
        System.out.println(res);
    }

    static int maxDiff(int[] arr){

        int max = arr[1] - arr[0]; int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        return max;
    }
}
