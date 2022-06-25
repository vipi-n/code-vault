package practice.random;

import java.util.Random;

public class RandomPWDGenerator {

    public static void main(String[] args) {

        generateRandomPassword(6);

    }

    public static void generateRandomPassword(int len) {

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String special = "!@#$%^&*()";

        String combination = upper+lower+numbers+special;
        char[] password = new char[len];
        Random random = new Random();

        // or you can use stringbuilder

/*        StringBuilder stringBuilder = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            stringBuilder.append(combination.charAt(random.nextInt(combination.length())));
        }
        System.out.println(stringBuilder.toString());*/

        for (int i = 0; i < len; i++) {
            password[i] = combination.charAt(random.nextInt(combination.length()));
        }
        System.out.println(new String(password));

    }
}
