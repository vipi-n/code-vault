// https://leetcode.com/problems/permutation-in-string/description/

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len > s2Len) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(char i : s1.toCharArray()) {
            arr1[i - 'a']++;
        }

        int i = 0;
        int j = s1Len - 1;

        while(j < s2Len) {

            for(int k = i; k <= j; k++){
                arr2[s2.charAt(k) - 'a']++;
            }          
            if(Arrays.equals(arr1, arr2)) { // if s1 permutation is in s2, that means s1 anagram should present in s2
                return true;
            }
            j++;
            i++;
            Arrays.fill(arr2, 0);
             
        }
        return false;
        
    }

    // optimized

    
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) return false;

        int[] arr1 = new int[26]; // frequency of s1
        int[] arr2 = new int[26]; // frequency of current window in s2

        for (int i = 0; i < s1Len; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arr1, arr2)) return true;

        for (int i = s1Len; i < s2Len; i++) {
            arr2[s2.charAt(i) - 'a']++;                          // add new char to window
            arr2[s2.charAt(i - s1Len) - 'a']--;                  // remove old char from window

            if (Arrays.equals(arr1, arr2)) return true;
        }

        return false;
    }
}
}
