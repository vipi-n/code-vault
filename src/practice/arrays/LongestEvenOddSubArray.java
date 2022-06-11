package practice.arrays;

public class LongestEvenOddSubArray {

    public static void main(String[] args) {

        int arr[] = {5, 10, 20, 6, 3, 8};
        System.out.println(longestSub1(arr));
    }
    // naive
    public static int longestSub(int[] arr){
        int res = 1;
        for (int i = 0; i < arr.length ; i++) {
            int current = 1;

            for (int j = i + 1; j < arr.length; j++) {

                if ((arr[j] % 2 == 0 && arr[j - 1] % 2 != 0)
                        ||arr[j] % 2 != 0 && arr[j - 1] % 2 == 0){
                    current++;

                }else break;
            }
            res = Math.max(res, current);
        }
        return res;
    }

    //efficient
    public static int longestSub1(int[] arr){

        int result = 1;
        int current = 1;
        for (int i = 1; i < arr.length; i++) {

            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0)
                    ||arr[i] % 2 != 0 && arr[i - 1] % 2 == 0){
                current++;
                result = Math.max(result, current);

            }else current = 1;

        }
        return result;
    }


}
