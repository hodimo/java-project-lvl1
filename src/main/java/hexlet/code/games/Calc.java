package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Calc {
    public static void calc() {
        char[] operators = {'+', '-', '*'};
        Cli.greeting();
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < Engine.ROUNDS; i++) {
            final int index = Engine.randomNum(operators.length);
            final int operand1 = Engine.randomNum(Engine.END_BOUND);
            final int operand2 = Engine.randomNum(Engine.END_BOUND);
            final String question = String.format("%d %c %d", operand1, operators[index], operand2);
            final String correct = calculate(operators, index, operand1, operand2);
            Engine.interact(question, correct);
            Engine.showIfDone();
        }
    }

    private static String calculate(char[] operators, int ind, int o1, int o2) {
        switch (operators[ind]) {
            case ('+'):
                return Integer.toString(Math.addExact(o1, o2));
            case ('-'):
                return Integer.toString(Math.subtractExact(o1, o2));
            default:
                return Integer.toString(Math.multiplyExact(o1, o2));
        }
    }
}
