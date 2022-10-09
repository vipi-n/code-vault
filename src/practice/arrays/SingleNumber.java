package practice.arrays;

/**
 * https://leetcode.com/problems/single-number/
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber {
    public int singleNumber1(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
            // {2,1,4,5,2,4,1} -> ((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5.
        }
        return result;
    }
}
