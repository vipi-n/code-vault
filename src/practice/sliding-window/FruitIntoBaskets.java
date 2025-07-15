// https://leetcode.com/problems/fruit-into-baskets/description/

class Solution {
    public int totalFruit(int[] fruits) {

        int n = fruits.length;
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            
            if(map.size() > 2) {
                int leftFruit = fruits[l];
                if(map.get(leftFruit) == 1) {
                    map.remove(leftFruit);
                } else{
                    map.put(leftFruit, map.get(leftFruit) - 1);
                } 
                l++;
            } else {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;  
    }
}
