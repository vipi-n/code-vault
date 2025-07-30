
// https://www.geeksforgeeks.org/dsa/find-all-subsequences-with-sum-equals-to-k/

public class Solution  {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findSubs(int k, ArrayList<Integer> arr) {
        findSubsequence(0, 0, k, new ArrayList<>(), arr);
        return res;
    }

    public void findSubsequence(int ind, int sum, int k, ArrayList<Integer> cur, ArrayList<Integer> arr) {
        if (ind == arr.size()) {
            if (sum == k) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        // Include arr[ind]
        cur.add(arr.get(ind));
        sum += arr.get(ind);
        findSubsequence(ind + 1, sum, k, cur, arr);
        sum -= arr.get(ind);
        cur.remove(cur.size() - 1);

        // Exclude arr[ind]
        findSubsequence(ind + 1, sum, k, cur, arr);
    }
}
