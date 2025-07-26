// https://leetcode.com/problems/minimum-window-substring/description/

class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int startIndex = 0;
        int winStart = 0;
        int winEnd = 0;
        int n = s.length();
        int uniqueCharCount = freqMap.size();
        int minLen = Integer.MAX_VALUE;

        while (winEnd < n) {

            char ch = s.charAt(winEnd);
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) - 1);
                if (freqMap.get(ch) == 0) {
                    uniqueCharCount--;
                }
            }

            while (uniqueCharCount == 0) {
                int len = winEnd - winStart + 1;
                if (minLen > len) {
                    minLen = len;
                    startIndex = winStart;
                }
                ch = s.charAt(winStart);
                if (freqMap.containsKey(ch)) {
                    freqMap.put(ch, freqMap.get(ch) + 1);
                    if (freqMap.get(ch) > 0) {
                        uniqueCharCount++;
                    }
                }
                winStart++;
            }
            winEnd++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
