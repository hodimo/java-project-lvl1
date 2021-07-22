package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void even() {
        Engine.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        generateSentences();
        Engine.interact();
    }

    public static void generateSentences() {
        for (int i = 0; i < Engine.sentences.length; i++) {
            int num = Engine.RANDOM.nextInt(Engine.END_BOUND);
            String question = String.valueOf(num);
            String correct = num % 2 == 0 ? "yes" : "no";
            Engine.sentences[i][0] = question;
            Engine.sentences[i][1] = correct;
        }
    }
}
