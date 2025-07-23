//https://leetcode.com/problems/repeated-dna-sequences/description/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {

            String str = s.substring(i, i + 10);
            if (seen.contains(str)) {
                duplicates.add(str);
            } else
                seen.add(str);
        }

        return new ArrayList<>(duplicates);

    }
}
