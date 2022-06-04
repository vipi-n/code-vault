package practice.geeksforgeeks;

public class MoveZeroToEnd {

    public static void main(String[] args) {

        int[] res = moveToEnd(new int[]{1,0,3,4,0,1,1});
        for (int i : res){
            System.out.print(" " +i);
        }
    }

    public static int[] moveToEnd(int[] arr){

/*        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == 0){
                for (int j = i + 1; j < arr.length ; j++) {
                    if (arr[j] != 0){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }*/
        int count = 0;  // count of non zero elements
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
                }
            }
        return arr;
    }

}
