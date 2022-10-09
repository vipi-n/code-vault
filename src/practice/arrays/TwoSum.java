package practice.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
 * to target.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] temp = {2,7,11,15};
        int target = 9;
        int[] res = twoSumOp(temp, target);
        for(int i: res){
            System.out.print(i +" ");
        }
    }
    public static int[] twoSumOp(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}
