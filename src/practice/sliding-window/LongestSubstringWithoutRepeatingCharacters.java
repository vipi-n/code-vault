//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class LongestSubstringWithoutRepeatingCharacters {
    public long maximumSubarraySum(int[] nums, int k) {

       Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        long maxSum = 0;
        long currSum = 0;

        while(j < n) {

            while(set.contains(nums[j])) {
                 set.remove(nums[i]);
                 currSum -= nums[i];
                 i++;
            } 

            set.add(nums[j]);     
            currSum += nums[j];
            if(j - i + 1 == k) {
               maxSum = Math.max(maxSum, currSum);
               currSum = currSum - nums[i];
               set.remove(nums[i]);
               i++;
               j++;
            } else {
                j++;
            }
        }
        return maxSum;
    }

    // HashMap

    public int lengthOfLongestSubstring(String s) {
      
    
      int i = 0;
      int j = 0;
      int n = s.length();
      if(n <= 1) return n;
      HashMap<Character, Integer> map = new HashMap<>();
      int max = 0;

      while(j < n) {

        char ch = s.charAt(j);

        if(map.containsKey(ch)) {
           i = Math.max(i, map.get(ch) + 1);
        }
        map.put(ch, j);
        max = Math.max(max, j - i + 1);
        j++;
      }  
      return max;
    }
}
