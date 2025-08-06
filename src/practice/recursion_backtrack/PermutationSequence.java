// https://leetcode.com/problems/permutation-sequence/description/

class Solution {
    public String getPermutation(int n, int k) {
        
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            fact = fact * i;
            list.add(i);
        }
        // using 0 based index
        k = k - 1;
        StringBuilder res = new StringBuilder();
        while(list.size() > 0) {
            fact = fact / list.size();
            res = res.append(list.get(k / fact));
            list.remove(k / fact);
            k = k % fact;
        }
        return res.toString();
    }
}
