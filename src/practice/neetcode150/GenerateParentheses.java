// https://leetcode.com/problems/generate-parentheses/description/

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        backTrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void backTrack(List<String> list, StringBuilder str, int open, int close, int n) {

        if(close > open) {
            return;
        }
        if(close == open && str.length() == 2*n) {
           list.add(str.toString());
           return;
        }
        if(open < n) {
            str.append("(");
            backTrack(list, str, open + 1, close, n);
            str.deleteCharAt(str.length() - 1);
        }
        if(open > close) {
            str.append(")");
            backTrack(list, str, open, close + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
