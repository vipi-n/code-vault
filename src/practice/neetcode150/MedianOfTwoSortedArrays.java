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

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length) {
           return findMedianSortedArrays(nums2, nums1); 
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        while (low <= high) {  

            int partitionX =  (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
            
            

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if((x + y) % 2 == 0) {
                   return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY) ;
                }
            } else if(maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
            
        }
        return -1;
    }
}

