package practice.stack;

import java.util.ArrayDeque;

public class PreviousGreaterElement {
    public static void main(String[] args) {

        int[] arr=new int[]{20,30,10,5,15};
        findGreater(arr);
        System.out.println("--------------");
        findGreater1(arr);
    }

    public static void findGreater(int[] arr){

        for (int i = 0; i < arr.length ; i++) {
            int j;
            for (j = i - 1; j >= 0 ; j--) {
                if (arr[i] < arr[j]){
                    System.out.println("greater element for " +arr[i]+ " is " +arr[j]);
                    break;
                }
            }
            if (j == -1) System.out.println("greater element for " +arr[i]+ " is -1");
        }
    }

    // using stack
    public static void findGreater1(int[] arr){

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        System.out.println("greater element for " +arr[0]+ " is -1");

        for (int i = 1; i < arr.length ; i++) {

            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            int greater = stack.isEmpty() ? -1 : stack.peek();
            System.out.println("greater element for " +arr[i]+ " is " +greater);
            stack.push(arr[i]);
        }
    }
}

