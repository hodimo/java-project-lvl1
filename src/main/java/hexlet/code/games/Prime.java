package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final int BOUND = 1000;

    public static void prime() {
        Engine.interact(generateSentences(),
                "Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    private static String[][] generateSentences() {
        String[][] sentences = new String[Engine.ROUNDS][2];
        for (int i = 0; i < sentences.length; i++) {
            int num = Utils.random(BOUND);
            String question = String.valueOf(num);
            String correct = isPrime(num) ? "yes" : "no";
            sentences[i][0] = question;
            sentences[i][1] = correct;
        }
        return sentences;
    }

    private static boolean isPrime(int num) {
        final int startIterator = 3;
        int sqrtNum = (int) Math.sqrt(num) + 1;

        if (num < 2) {
            return false;
        }
        if (num <= startIterator) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }
        for (int i = startIterator; i <= sqrtNum; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
