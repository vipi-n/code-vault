// https://leetcode.com/problems/min-stack/

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() > val) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        minStack.pop();
        stack.pop();
    }
    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
