package practice.geeksforgeeks;

public class SecondLargets {

    public static void main(String[] args) {
        int[] nums = {34, 35, 35 , 34, 1, 10, 34, 1};
        int size = second(nums);

        System.out.println(size);
    }

    public static int second(int[] nums){

        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] > max){
                smax = max;
                max = nums[i];

            }
            else if (nums[i] != max && nums[i] > smax)
                    smax = nums[i];
        }
        return smax;
    }
}
