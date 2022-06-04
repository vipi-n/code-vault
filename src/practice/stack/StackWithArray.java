package practice.stack;

public class StackWithArray {

    int arr[];
    int cap;
    int top;

    StackWithArray(int c){
        cap = c;
        top = -1;
        arr = new int[cap];
    }
    void push(int x) throws Exception {
        if (top == cap -1){
            throw new Exception("StackOverFlow : ");
        }
        top++;
        arr[top] = x;
    }
    int pop() throws Exception{
        if (top == -1){
            throw new Exception("StackUnderFlow : ");
        }
        int temp = arr[top];
        top --;
        return temp;
    }
    int peek(){
        return arr[top];
    }
    int size(){
        return top+1;
    }
    boolean isEmpty(){
        return (top == -1);
    }

    public static void main(String[] args) throws Exception {
        StackWithArray s=new StackWithArray(5);
        s.push(5);
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
    }

}
