package practice.geeksforgeeks.arrays;

public class SubArrayOfArray {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
/*        for (int i = 0; i < nums.length ; i++) {
            for (int j = i + 1; j < nums.length ; j++) {

                System.out.print("{");
                for (int k = i; k < j ; k++) {
                    System.out.print(nums[k]);
                }
                System.out.println("}");
            }
        }*/
        printAll(nums,0);
    }

    public static void printAll(int[] nums, int start){
        if (start == nums.length) return;
        String res = "";
        for (int i = start; i < nums.length ; i++) {
            res += nums[i];
            System.out.print("[ " +res+ " ]");
        }
        printAll(nums, start + 1);
        }

    }

