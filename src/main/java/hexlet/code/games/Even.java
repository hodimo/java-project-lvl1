package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Even {
    public static void even() {
        Cli.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < Engine.rounds; i++) {
            final int num = Engine.randomNum(100);
            final String question = Integer.toString(num);
            final String correct = num % 2 == 0 ? "yes" : "no";
            Engine.interaction(question, correct);
            Engine.showIfDone();
        }
    }
}
