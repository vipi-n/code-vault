// https://leetcode.com/problems/longest-consecutive-sequence/description/

class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        
        int ans = 0;
          for(int n : set) {
            
            if(!set.contains(n - 1)) {
                int m = n + 1;
                while(set.contains(m)) {
                    m++;
                }
                ans = Math.max(ans, m - n);
            }
            
          }
          return ans;
    }
}
