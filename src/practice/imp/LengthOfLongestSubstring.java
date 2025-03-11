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
}
