package practice.string;
import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {

        String str = "Vipin";
        System.out.println(reverse3(str));
    }
    public static String reverse(String str){
        if (str.length() <= 0 || str == null) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }
    public static String reverse1(String str){
        String res = "";
        for (int i = str.length() - 1; i >= 0 ; i--) {
             res += str.charAt(i);
        }
        return res;
    }

    // using stack
    public static char[] reverse2(String str){
        Stack<Character> stack = new Stack<>();
        char[] res = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            res[i] = stack.peek();
            stack.pop();
        }
        return res;


    }
    public static char[] reverse3(String str){
        char[] temp = str.toCharArray();
        int j = 0;
        for (int i = str.length() - 1; i >= 0 ; i--) {
            temp[j] = str.charAt(i);
            j++;
        }
        return temp;
    }

    public static String reverse4(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return reverse4(str.substring(1)) + str.charAt(0);
    }

    public char[] reverseString(char[] s) {
        char temp;
        int len = s.length;
        for (int i = 0; i < len/2 ; i++) {
            temp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = temp;
        }
        return s;
    }
}
