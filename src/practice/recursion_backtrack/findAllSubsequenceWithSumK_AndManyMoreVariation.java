
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

    // to find only one
     public boolean findSubsequence(int ind, int sum, int k, ArrayList<Integer> cur, ArrayList<Integer> arr) {
        if (ind == arr.size()) {
            if (sum == k) {
                res.add(new ArrayList<>(cur));
                return true;
            }
            return false;
        }

        cur.add(arr.get(ind));
        sum += arr.get(ind);
        if (findSubsequence(ind + 1, sum, k, cur, arr)) return true;
        sum -= arr.get(ind);
        cur.remove(cur.size() - 1);

        if (findSubsequence(ind + 1, sum, k, cur, arr)) return true;

        return false;
    }

    // Count all subsequences whose sum equals k
         public int findSubsequence( int ind, int sum, int k, ArrayList<Integer> cur,  ArrayList<Integer> arr ) {

        if (ind == arr.size()) {
            if (sum == k) {
                res.add(new ArrayList<>(cur));
                return 1;
            }
            return 0;
        }
         cur.add(arr.get(ind));
         sum += arr.get(ind);

         int left = findSubsequence(ind + 1, sum, k, cur, arr);
         sum -= arr.get(ind);
         cur.remove(cur.size() - 1);

         int right = findSubsequence(ind + 1, sum, k, cur, arr);
         return left + right;
    }
}
