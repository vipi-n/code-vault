// https://leetcode.com/problems/reverse-vowels-of-a-string/

class Solution {
    public String reverseVowels(String s) {
       if(s == null || s.length()==0) return s;
      char[] arr = s.toCharArray();
      String vowel = "aeiouAEIOU";
      int left = 0;
      int right = s.length() - 1;

      while(left < right) {
          
          while(left < right && !vowel.contains(arr[left]+"")) {
             left++;
          }

          while(left < right && !vowel.contains(arr[right]+"")) {
             right--;
          }

          char temp = arr[right];
          arr[right] = arr[left];
          arr[left] = temp;
          left++;
          right--;
      }
      return new String(arr);
    }
}
