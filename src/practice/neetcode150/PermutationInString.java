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
}
