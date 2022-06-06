package practice.geeksforgeeks.string;

public class AllSubStringOfString {

    public static void main(String[] args) {
        printAllSubs("Vipin",0);

    }
    public static void printAllSubs(String s, int start){
        if (start == s.length()) return;

        String res = "";
        for (int i = start; i < s.length() ; i++) {
            res += s.charAt(i);
            System.out.print("[ " +res+ " ]");
        }
        printAllSubs(s, start + 1);
    }
}
