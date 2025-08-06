// https://leetcode.com/problems/permutation-sequence/description/
// https://chatgpt.com/s/t_6892b80c4fd48191ba91194feb36d536

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
            fact = fact / list.size(); // devide in blocks
            res = res.append(list.get(k / fact)); // Which block the k-th permutation falls into
            list.remove(k / fact);
            k = k % fact;
        }
        return res.toString();
    }
}
