package practice.queue;

import java.util.Stack;

public class QueueWithStack {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();


    public static void add(int x){
        stack1.push(x);
    }
    public static int poll(){

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }
    public static int peek(){

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.peek();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }

    public static void print(){
        System.out.println(stack1);
    }

    public static void main(String[] args) {

        add(10);
        add(20);
        add(30);
        add(40);
        System.out.println("peek " +peek());
        print();
        poll();
        System.out.println("peek " +peek());
        print();
    }
}
