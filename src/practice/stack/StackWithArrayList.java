package practice.stack;

import java.util.ArrayList;

public class StackWithArrayList {

    ArrayList<Integer> list = new ArrayList<>();

    void push(int x){
        list.add(x);
    }

    int pop(){
        int res = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return res;
    }

    int peek(){
        return list.get(list.size() - 1);
    }

    boolean isEmpty(){
        return list.isEmpty();
    }

    int size(){
        return list.size();
    }

    public static void main(String[] args) throws Exception {

        StackWithArrayList s=new StackWithArrayList();
        s.push(5);
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
    }
}
