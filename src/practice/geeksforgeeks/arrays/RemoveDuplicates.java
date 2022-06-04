package practice.geeksforgeeks.arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {

        int[] nums = {1,2,2,2,4,5,5};
        int[] res = removeDuplicates(nums);
       // System.out.println(res);
        for (int i : res)
            System.out.print( " " +i);

    }
    static int[] removeDuplicates(int[] arr){
        /*int[] newArr = new int[arr.length];
        newArr[0] = arr[0];
        int res = 1;
        for (int i = 1; i <arr.length ; i++) {

            if (newArr[res - 1] != arr[i]){
                newArr[res] = arr[i];
                res++;
            }
        }
        for (int i : newArr){
            System.out.print(" " +i);
        }
        return newArr.length ;*/

        int res = 1;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[res - 1] != arr[i]){
                arr[res] = arr[i];
                res++;
            }
        }
        return arr;
    }
}
