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

    // another brute
        public int numberOfSubstrings(String s) {
        
        int n = s.length();
        int count = 0;
        int[] temp;

        for(int i = 0; i < n; i++) {
            temp = new int[3];
            for(int j = i; j < n; j++) {
                temp[s.charAt(j) - 'a'] = 1;
                if(temp[0] + temp[1] + temp[2] == 3) {
                  count += n - j;
                  break;
                } 
            }
        }
        return count;
    }

    // optimized
        public int numberOfSubstrings(String s) {
        
        int n = s.length();
        int count = 0;
        int[] temp = new int[]{-1, -1, -1};

        for(int i = 0; i < n; i++) {

            temp[s.charAt(i) - 'a'] = i;
                if(temp[0] != -1 && temp[1] != -1 && temp[2] != -1) {
                  count += 1 + Math.min(temp[0], Math.min(temp[1], temp[2]));
            } 
        }
        return count;
    }
}
