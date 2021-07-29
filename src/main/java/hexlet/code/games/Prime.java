package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void prime() {
        Engine.greeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        generateSentences();
        Engine.interact();
    }

    public static void generateSentences() {
        for (int i = 0; i < Engine.SENTENCES.length; i++) {
            int num = Engine.RANDOM.nextInt(Engine.END_BOUND);
            String question = String.valueOf(num);
            String correct = isPrime(num);
            Engine.SENTENCES[i][0] = question;
            Engine.SENTENCES[i][1] = correct;
        }
    }

    private static String isPrime(int num) {
        final int startIterator = 3;
        int sqrtNum = (int) Math.sqrt(num) + 1;
        if (num < 2) {
            return "no";
        }
        if (num <= startIterator) {
            return "yes";
        }

        if (num % 2 == 0) {
            return "no";
        }
        for (int i = startIterator; i <= sqrtNum; i += 2) {
            if (num % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
