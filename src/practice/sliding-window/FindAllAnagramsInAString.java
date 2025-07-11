// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int n = s.length();
        int i = 0, j = 0;

        int[] freqP = new int[26];
        int[] freqS = new int[26];

        for (char ch : p.toCharArray()) {
            freqP[ch - 'a']++;
        }

        List<Integer> result = new ArrayList<>();

        while (j < n) {
           
            freqS[s.charAt(j) - 'a']++;
            // If window size is less than k, expand window
            if (j - i + 1 < k) {
                j++;
            }
            // If window size equals k, check and slide
            else if (j - i + 1 == k) {
                if (Arrays.equals(freqP, freqS)) {
                    result.add(i);
                }
                // Remove the leftmost character from window
                freqS[s.charAt(i) - 'a']--;
                i++;
                j++;
            }
        }

        return result;
    }
}
