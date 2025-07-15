// https://www.naukri.com/code360/problems/distinct-characters_2221410?leftPanelTabValue=PROBLEM

public class LongestSubstringWithKDistinctChars {

    public static int kDistinctChars(int k, String str) {
        
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int n = str.length();
        int maxLen = 0;

        while (j < n) {

            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1); 

            if (map.size() > k) {
                char ch = str.charAt(i);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1); // if count is 0, remove from map
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                    i++;
                }
            } else {
                maxLen = Math.max(maxLen, j - i + 1);
            } 
            j++;
        }
        return maxLen;
    }
}
