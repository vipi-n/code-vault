package practice.arrays;

public class MajorityElement {

    public static void main(String[] args) {

        System.out.println(majority1(new int[]{6,8,4,8,8}));
    }

    // naive
    public static int majority(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            int count = 1;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[i] == arr[j]){
                    count++;
                }
                if (count > arr.length/2){
                    return i;
                }
            }
        }
        return -1;
    }
    //efficient
    public static int majority1(int[] arr){

        int result = 0;
        int count = 1;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] ==  arr[result]){
                count++;
            }else count--;

            if (count == 0){
                result = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[result] == arr[i])
                count++;
            }
            if (count <= arr.length/2){
                System.out.println("count is :" +count+ " and result is: " +result);
                return -1;
            }
        return result;
    }

}
