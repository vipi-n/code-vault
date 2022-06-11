package practice.arrays;

 class DeleteFromArray {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        int x = 3;
        int size = delete(nums,3);
        System.out.println(size);
        for(int i : nums){
            System.out.print( " " +i);
        }

    }
    public static int delete(int[] nums, int x){
        int i ;
        for ( i = 0; i < nums.length ; i++) {
            if (nums[i] == x)
                break;
        }
        if (i == nums.length)  return nums.length;
        for (int j = i; j < nums.length - 1 ; j++) {
            nums[j] = nums[j+1];
        }
        return nums.length-1;
    }
}
