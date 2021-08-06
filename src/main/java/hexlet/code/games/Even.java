package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final int BOUND = 100;

    public static void even() {
        Engine.interact(generateSentences(),
                "Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    private static String[][] generateSentences() {
        String[][] sentences = new String[Engine.ROUNDS][2];
        for (int i = 0; i < sentences.length; i++) {
            int number = Utils.random(BOUND);
            String question = String.valueOf(number);
            String correct = number % 2 == 0 ? "yes" : "no";
            sentences[i][0] = question;
            sentences[i][1] = correct;
        }
        return sentences;
    }
}
