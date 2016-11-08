package com.udacity.gradle.builditbigger.gcemodule;
import com.example.javaJoke;
/**
 * The object model for the data we are sending through endpoints
 */
public class JokeBean {

    public String getJoke() {
        return javaJoke.getRandomJoke();
    }
}