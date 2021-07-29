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

    private static final int LEAST_PRIME1 = 2;
    private static final int LEAST_PRIME2 = 3;
    private static final int INCREMENT = 6;

    private static String isPrime(int num) {
        if (num < LEAST_PRIME1) {
            return "no";
        }
        if (num == LEAST_PRIME1 || num == LEAST_PRIME2) {
            return "yes";
        }
        if (num % LEAST_PRIME1 == 0 || num % LEAST_PRIME2 == 0) {
            return "no";
        }
        int sqrtNum = (int) Math.sqrt(num) + 1;
        for (int i = INCREMENT; i <= sqrtNum; i += INCREMENT) {
            if (num % (i - 1) == 0 || num % (i + 1) == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
