package practice.geeksforgeeks;

public class ReverseArray {

    public static void main(String[] args) {
        int[] nums = {1,2,8,4,5};
        int[] res = reverse(nums);
        for(int i : res){
            System.out.print(" " +i);
        }
    }

    static int[] reverse(int[] nums){
/*        int[] res = new int[nums.length];
        int j = 0;
        for (int i = nums.length -1; i >= 0 ; i--) {
            res[j] = nums[i];
            j++;
        }
        return res;*/


/*        for (int i = 0; i <nums.length/2 ; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;*/

        int low = 0;
        int high = nums.length - 1;

        while (low  < high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        return nums;
    }
}
