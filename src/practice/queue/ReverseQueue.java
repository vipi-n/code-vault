package practice.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {

        Queue<Integer> queue  = new LinkedList<>();
        queue.add(12);
        queue.add(5);
        queue.add(15);
        queue.add(20);

        System.out.println("input queue is " +queue);
        Queue<Integer> res = reverse1(queue);
        System.out.println("reverse queue is " + res);
    }

    //iterative
    public static Queue<Integer> reverse(Queue<Integer> queue){

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
        return queue;
    }
    //recursive
    public static Queue<Integer> reverse1(Queue<Integer> queue){

        if (queue.isEmpty()) return null;
        int top = queue.poll();
        reverse1(queue);
        queue.add(top);
        return queue;

    }

}
