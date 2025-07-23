//https://leetcode.com/problems/valid-triangle-number/description/

class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        for(int k = n - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;

            while(i < j) {
                if(nums[i] + nums[j] > nums[k]) {
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}

