package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Even {
    public static void even() {
        Cli.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int num = Engine.randomNum(Engine.END_BOUND);
            String question = Integer.toString(num);
            String correct = num % 2 == 0 ? "yes" : "no";
            Engine.interaction(question, correct);
            Engine.showIfDone();
        }
    }
}
