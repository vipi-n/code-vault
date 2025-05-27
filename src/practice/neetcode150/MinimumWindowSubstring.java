// https://leetcode.com/problems/minimum-window-substring/description/

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] charCount = new int[128];

        for (char c : t.toCharArray()) {
            charCount[c]++;
        }

        int windowStart = 0;
        int charsNeeded = t.length();
        int[] bestWindow = new int[]{0, Integer.MAX_VALUE};

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

            char currentChar = s.charAt(windowEnd);
            if (charCount[currentChar] > 0) {
                charsNeeded--;
            }
            charCount[currentChar]--;

            if (charsNeeded == 0) {
                while (true) {
                    char startChar = s.charAt(windowStart);
                    if (charCount[startChar] == 0) {
                        break;
                    }
                    charCount[startChar]++;
                    windowStart++;
                }

                if (windowEnd - windowStart < bestWindow[1] - bestWindow[0]) {
                    bestWindow[0] = windowStart;
                    bestWindow[1] = windowEnd;
                }

                char removedChar = s.charAt(windowStart);
                charCount[removedChar]++;
                charsNeeded++;
                windowStart++;
            }
        }

        return bestWindow[1] >= s.length() ? "" : s.substring(bestWindow[0], bestWindow[1] + 1); 
    }
}
