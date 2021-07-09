package src.main.java.hexlet.code;

import java.util.Scanner;

class Cli {
    static void greeting() {
        Scanner in = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String name = in.nextLine();
        System.out.printf("Hello, %s!\n", name);
        in.close();
    }
}
