package practice.arrays;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {4,1,6,2,1,1,1,9}; int  k = 5;
        System.out.println(subarraySum(nums, k));

    }
    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k) count++;

            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
