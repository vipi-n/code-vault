package practice.string;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 */
public class FirstUniqueCharacter_in_a_String {
    public int firstUniqChar(String s) {

        int[] resultArr = new int[26];
        for (int i = 0; i <s.length() ; i++) {
            resultArr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i <s.length() ; i++) {
            if (resultArr[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
