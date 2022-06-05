package practice.geeksforgeeks.arrays;

public class MaximumCons1_s {
    public static void main(String[] args) {

        int[] arr = new int[]{1,1,1,0,1,1,1,1};
        System.out.println(count(arr));
    }
/*    static int count(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = 0;
            for (int j = i; j < arr.length ; j++) {
                if (arr[j] == 1){
                    current++;
                }else break;;
            }
            count = Math.max(count, current); //3
        }
        return count;
    }*/
    static int count(int[] arr) {

        int count = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
            } else {
                count++;
                result = Math.max(count, result); //3
            }
        }
        return count;
    }
}
