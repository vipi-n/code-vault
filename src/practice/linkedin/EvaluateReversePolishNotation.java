// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/ 

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(Integer.parseInt(s));
            } else {
                if (s.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                } else if (s.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if (s.equals("-")) {
                    int last = stack.pop();
                    stack.push(stack.pop() - last);
                } else if (s.equals("/")) {
                    int last = stack.pop();
                    stack.push(stack.pop() / last);
                }
            }
        }

        return stack.pop();
    }
}
