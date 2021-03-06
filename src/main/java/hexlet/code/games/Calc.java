package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final int START_BOUND = -50;
    private static final int END_BOUND = 50;

    public static void calc() {
        Engine.interact(generateSentences(),
                "What is the result of the expression?");
    }

    private static String[][] generateSentences() {
        String[][] sentences = new String[Engine.ROUNDS][2];
        for (int i = 0; i < sentences.length; i++) {
            int index = Utils.random(OPERATORS.length);
            int operand1 = Utils.randomInRange(START_BOUND, END_BOUND);
            int operand2 = Utils.randomInRange(START_BOUND, END_BOUND);
            String question = String.format("%d %c %d", operand1, OPERATORS[index], operand2);
            String correct = calculate(index, operand1, operand2);
            sentences[i][0] = question;
            sentences[i][1] = correct;
        }
        return sentences;
    }

    private static String calculate(int ind, int o1, int o2) {
        switch (OPERATORS[ind]) {
            case ('+'):
                return String.valueOf(Math.addExact(o1, o2));
            case ('-'):
                return String.valueOf(Math.subtractExact(o1, o2));
            case ('*'):
                return String.valueOf(Math.multiplyExact(o1, o2));
            default:
                throw new RuntimeException("Unexpected operator: " + OPERATORS[ind]);
        }
    }
}
