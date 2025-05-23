// https://leetcode.com/problems/longest-repeating-character-replacement/description/

class Solution {
    public int characterReplacement(String s, int k) {

       int[] freq = new int[26];
       int maxLen = 0;
       int mostFreqLetter = 0;
       int len = s.length();
       int left = 0;

       for(int right = 0; right < len; right++) {
          
          freq[s.charAt(right) - 'A']++;
          mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);
          
          int lettersToChange = (right - left + 1) - mostFreqLetter;
          if(lettersToChange > k) {
            freq[s.charAt(left) - 'A']--;
            left++;
          }
          maxLen = Math.max(maxLen, right - left + 1);

       }
       return  maxLen;
    }
}
