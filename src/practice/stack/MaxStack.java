// https://www.naukri.com/code360/problems/max-stack_985280?leftPanelTabValue=PROBLEM

import java.util.Stack;
public class MaxStack {
	
	Stack<Integer> stack;
	Stack<Integer> maxStack;

	public MaxStack() {
		this.stack = new Stack<>();
		this.maxStack = new Stack<>();
	}

	public void specialPush(int value) {
		
		stack.push(value);
		if(maxStack.isEmpty() || maxStack.peek() < value) {
			   maxStack.push(value);
		   } else {
			   maxStack.push(maxStack.peek());
		   }
		}
	
	public int specialPop() {
        if (stack.isEmpty()) return -1;
        maxStack.pop();
        return stack.pop();
    }

    public int specialTop() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int specialMax() {
        if (maxStack.isEmpty()) return -1;
        return maxStack.peek(); // just peek the current max
    }

}
