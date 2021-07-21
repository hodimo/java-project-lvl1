package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Calc {
    public static void calc() {
        char[] operators = {'+', '-', '*'};
        Cli.greeting();
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int index = Engine.randomNum(operators.length);
            int operand1 = Engine.randomNum(Engine.END_BOUND);
            int operand2 = Engine.randomNum(Engine.END_BOUND);
            String question = String.format("%d %c %d", operand1, operators[index], operand2);
            String correct = calculate(operators, index, operand1, operand2);
            boolean isSuccess = Engine.interact(question, correct);
            if (!isSuccess) {
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", Cli.getName());
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
