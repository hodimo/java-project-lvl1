package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void calc() {
        Engine.greeting();
        System.out.println("What is the result of the expression?");
        generateSentences();
        Engine.interact();
    }

    public static void generateSentences() {
        char[] operators = {'+', '-', '*'};
        for (int i = 0; i < Engine.SENTENCES.length; i++) {
            int index = Engine.RANDOM.nextInt(operators.length);
            int operand1 = Engine.RANDOM.nextInt(Engine.END_BOUND);
            int operand2 = Engine.RANDOM.nextInt(Engine.END_BOUND);
            String question = String.format("%d %c %d", operand1, operators[index], operand2);
            String correct = calculate(operators, index, operand1, operand2);
            Engine.SENTENCES[i][0] = question;
            Engine.SENTENCES[i][1] = correct;
        }
    }

    private static String calculate(char[] operators, int ind, int o1, int o2) {
        switch (operators[ind]) {
            case ('+'):
                return String.valueOf(Math.addExact(o1, o2));
            case ('-'):
                return String.valueOf(Math.subtractExact(o1, o2));
            default:
                return String.valueOf(Math.multiplyExact(o1, o2));
        }
    }
}
