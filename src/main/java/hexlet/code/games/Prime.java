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
        for (int i = 0; i < Engine.sentences.length; i++) {
            int num = Engine.RANDOM.nextInt(Engine.END_BOUND);
            String question = String.valueOf(num);
            String correct = isPrime(num);
            Engine.sentences[i][0] = question;
            Engine.sentences[i][1] = correct;
        }
    }

    private static String isPrime(int num) {
        if (num < 2) {
            return "no";
        }
        if (num == 2 || num == 3) {
            return "yes";
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return "no";
        }
        int sqrtNum = (int) Math.sqrt(num) + 1;
        for (int i = 6; i <= sqrtNum; i += 6) {
            if (num % (i - 1) == 0 || num % (i + 1) == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
