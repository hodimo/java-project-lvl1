package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;

public class GCD {
    public static void gcd() {
        Engine.greeting();
        System.out.println("Find the greatest common divisor of given numbers.");
        generateSentences();
        Engine.interact();
    }

    public static void generateSentences() {
        for (int i = 0; i < Engine.sentences.length; i++) {
            int num1 = Engine.RANDOM.nextInt(Engine.END_BOUND);
            int num2 = Engine.RANDOM.nextInt(Engine.END_BOUND);
            String question = String.format("%d %d", num1, num2);
            String correct = String.format("%d", findGCD(num1, num2));
            Engine.sentences[i][0] = question;
            Engine.sentences[i][1] = correct;
        }
    }

    private static int findGCD(int num1, int num2) {
        int gcd = 1;
        ArrayList<Integer> dividers1 = findDividers(num1);
        for (Integer dividers : dividers1) {
            if (num2 % dividers == 0) {
                gcd *= dividers;
            }
        }
        return gcd;
    }

    private static ArrayList<Integer> findDividers(int num1) {
        ArrayList<Integer> dividers = new ArrayList<>();
        int num = num1;
        int divider = 2;
        while (num / divider >= 1) {
            if (num % divider == 0) {
                num = num / divider;
                dividers.add(divider);
            } else if (divider == 2) {
                divider++;
            } else {
                divider += 2;
            }
        }
        return dividers;
    }
}
