package practice.stack;

import java.util.ArrayDeque;

public class BalancedParenthesis {

    public static void main(String[] args) {

        String s = "{}()[]";
        System.out.println(isBalanced(s));
    }

    public static boolean isBalanced(String s){

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '(' || x == '{' || x == '['){
                stack.push(x);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }else if(!isMatching(stack.peek(), x))
                    return false;
                    else
                        stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatching(int a, int b){
       return  ((a == '(' && b == ')')
               || (a == '{' && b == '}')
               ||(a == '[' && b == ']'));
    }
}
