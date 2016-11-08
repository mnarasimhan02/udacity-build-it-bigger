package com.example;
import java.util.Random;
public class javaJoke {
    private static String[] jokes;

    static {
        jokes = new String[5];
        jokes[0] = "Q: Why do java programmers wear glasses?\n" +
                "A: Because they don't C.";
        jokes[1] = "Q: How many programmers does it take to change a light bulb? \n" +
                "A: none, that's a hardware problem";
        jokes[2] = "Q: \"Whats the object-oriented way to become wealthy?\"\n" +
                "A: Inheritance";
        jokes[3] = "Q: What do you call a programmer from Finland?\n" +
                "A: Nerdic";
        jokes[4] = "Q: Why did the programmer quit his job?\n" +
                "A: Because he didn't get arrays (a raise)";
    }

    public static String getRandomJoke() {
        return jokes[new Random().nextInt(jokes.length)];
    }
}
