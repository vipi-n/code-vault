package practice.geeksforgeeks;

public class checkIfArraySorted {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1, 1,5};
        boolean bol = sorted(nums);
        System.out.println(bol);
    }

/*    static boolean sorted(int[] arr){

        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[i] > arr[j])
                    return false;
            }
        }
        return true;
    }*/
       static boolean sorted(int[] arr){
           for (int i = 1; i < arr.length; i++) {
               if (arr[i - 1] > arr[i])
                   return false;
           }
           return true;
       }

}
