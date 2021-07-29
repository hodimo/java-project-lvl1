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
        for (int i = 0; i < Engine.SENTENCES.length; i++) {
            int num1 = Engine.RANDOM.nextInt(Engine.END_BOUND);
            int num2 = Engine.RANDOM.nextInt(Engine.END_BOUND);
            String question = String.format("%d %d", num1, num2);
            String correct = String.format("%d", findGCD(num1, num2));
            Engine.SENTENCES[i][0] = question;
            Engine.SENTENCES[i][1] = correct;
        }
    }

    private static int findGCD(int num1, int num2) {
        int gcd = 1;
        int num = num2;
        ArrayList<Integer> dividers1 = findDividers(num1);
        for (Integer divider : dividers1) {
            if (num % divider == 0) {
                gcd *= divider;
                num /= divider;
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
