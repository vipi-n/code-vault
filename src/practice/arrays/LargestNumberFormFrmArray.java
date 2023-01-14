package practice.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormFrmArray {

    public static String largestNumber(int[] nums) {
        String result = "";

        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            asStrs[i] = String.valueOf(nums[i]);

        Arrays.sort(asStrs, new Comparator<String>() {
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return yx.compareTo(xy);
            }
        });

        if (asStrs[0].equals("0")) {
            return "0";
        }
        for (String s : asStrs) {
            result += s;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9})); // 9534330
    }
}



