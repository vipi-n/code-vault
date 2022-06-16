package practice.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {

    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();

    public static void push(int x){
      while (!queue1.isEmpty()){
          queue2.add(queue1.poll());
      }
      queue1.add(x);
      while (!queue2.isEmpty()){
          queue1.add(queue2.poll());
      }
    }
    public static int pop(){
        return queue1.poll();
    }

    public static int peek(){
        return queue1.peek();
    }
    public static void print(){
        System.out.println(queue1);
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        push(40);

        System.out.println(peek());
        System.out.println("----------");

        System.out.println(pop());
        print();
        System.out.println(peek());

    }

}
