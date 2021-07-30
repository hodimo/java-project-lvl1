package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();

    public static int random(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int random(int startBound, int endBound) {
        return startBound + RANDOM.nextInt(endBound) * 2;
    }
}
