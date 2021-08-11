package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;

public class GCD {
    private static final int START_BOUND = 1;
    private static final int END_BOUND = 100;

    public static void gcd() {
        Engine.interact(generateSentences(),
                "Find the greatest common divisor of given numbers.");
    }

    private static String[][] generateSentences() {
        String[][] sentences = new String[Engine.ROUNDS][2];
        for (int i = 0; i < sentences.length; i++) {
            int num1 = Utils.randomInRange(START_BOUND, END_BOUND);
            int num2 = Utils.randomInRange(START_BOUND, END_BOUND);
            String question = String.format("%d %d", num1, num2);
            String correct = String.format("%d", findGCD(num1, num2));
            sentences[i][0] = question;
            sentences[i][1] = correct;
        }
        return sentences;
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
