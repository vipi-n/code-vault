// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        if(len <= 0) {
        return 0;
       }

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int right = 0; right < len; right++) {

            if(map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left); 
            }
            
            map.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }
}
