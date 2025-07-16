// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

// brute
class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        
        int n = s.length();
        int count = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.clear();
            for(int j = i; j < n; j++) {
                set.add(s.charAt(j));
                if(set.size() == 3) {
                  count = count + (n - j);
                  break; 
                } 
            }
        }
        return count;
    }
}
