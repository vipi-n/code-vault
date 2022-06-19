package practice.queue;

import java.util.LinkedList;
import java.util.Queue;

// generate number till n which have digits 5 and 6 only!
public class GenerateNumbersWithIGivenDigits {
    public static void main(String[] args) {
        generate(10);
    }

    public static void generate(int n){

        Queue<String> queue = new LinkedList<>();
        queue.add("5");
        queue.add("6");

        for (int i = 0; i < n; i++) {

            String curr = queue.poll();
            System.out.println(curr);
            queue.add(curr + "5");
            queue.add(curr + "6");
        }

    }
}
