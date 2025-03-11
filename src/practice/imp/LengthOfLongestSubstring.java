// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

       HashMap<Character, Integer> map = new HashMap<>();
       int maxLen = Integer.MIN_VALUE;
       int len = s.length();
       int j = 0;

       if(s.length() <= 0) {
        return 0;
       }

       for(int i = 0; i < len; i++) {
        
        if(map.containsKey(s.charAt(i))) {
            j = Math.max(j, map.get(s.charAt(i)) + 1);
        }
        map.put(s.charAt(i), i);
        maxLen = Math.max(maxLen, i - j + 1);
       } 
       return maxLen;
    }

    class Solution {
    public int lengthOfLongestSubstring_UsingSet(String s) {
      
        int result = 0;
        if(s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        
        while( j < s.length()){
            
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                result = Math.max(result, set.size());
            }else{
              set.remove(s.charAt(i));
                i++;
            }
        }

        return result;
    }
}
}
