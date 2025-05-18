// https://leetcode.com/problems/group-anagrams/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs) {

            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String val = String.valueOf(ch);

            if(!map.containsKey(val)) {
                map.put(val, new ArrayList<>());
            }
            map.get(val).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
