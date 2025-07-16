//https://leetcode.com/problems/longest-repeating-character-replacement/

class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxCount = 0; // count of the most frequent character in the current window
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            maxCount = Math.max(maxCount, freq[ch - 'A']);

            // check if we need to shrink the window
            // minimum number of replacements needed = window size - count of the most frequent character
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
