package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Arrays;

public class Progression {
    private static final int DEFAULT_LENGTH = 5;
    private static final int LENGTH_BOUND = 6;
    private static final int DEFAULT_DIFF = 1;
    private static final int DIFF_BOUND = 9;

    public static void progression() {
        Engine.greeting();
        System.out.println("What number is missing in the progression?");
        generateSentences();
        Engine.interact();
    }

    public static void generateSentences() {
        for (int i = 0; i < Engine.SENTENCES.length; i++) {
            ArrayList<Integer> progression = generateProgression();
            int unknown = progression.get(Engine.RANDOM.nextInt(progression.size()));
            String question = Arrays.toString(progression.toArray())
                    .replaceAll("[\\[\\],g]", "")
                    .replaceFirst("(" + unknown + ")", "..");
            String correct = Integer.toString(unknown);
            Engine.SENTENCES[i][0] = question;
            Engine.SENTENCES[i][1] = correct;
        }
    }

    private static ArrayList<Integer> generateProgression() {
        int length = generateLength();
        int initNum = Engine.RANDOM.nextInt(Engine.END_BOUND);
        int difference = DEFAULT_DIFF + Engine.RANDOM.nextInt(DIFF_BOUND);
        ArrayList<Integer> progression = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            progression.add(initNum);
            initNum += difference;
        }
        return progression;
    }

    private static int generateLength() {
        return DEFAULT_LENGTH + Engine.RANDOM.nextInt(LENGTH_BOUND);
    }
}
