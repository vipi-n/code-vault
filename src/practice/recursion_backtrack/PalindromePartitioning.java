// https://leetcode.com/problems/palindrome-partitioning/description/

class PalindromePartitioning {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {

        List<String> list = new ArrayList<>();
        solve(s, list, 0);
        return res;
    }

    private void solve(String s, List<String> list, int index) {

        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                solve(s, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int i, int j) {

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
