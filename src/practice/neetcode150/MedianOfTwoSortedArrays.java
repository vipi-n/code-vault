// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

// brute-force

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;
        int[] res = new int[len];
        int j = 0;

        for(int i = 0; i < len; i++) {   
            if(i < nums1.length)res[i] = nums1[i];
            else {
                res[i] = nums2[j++];
            }
        }
        
        Arrays.sort(res);
        if(len % 2 == 0) {
           return (res[len / 2] + res[(len / 2) - 1]) / 2.0;
        } else {
            return res[len / 2];
        }
    }
}

