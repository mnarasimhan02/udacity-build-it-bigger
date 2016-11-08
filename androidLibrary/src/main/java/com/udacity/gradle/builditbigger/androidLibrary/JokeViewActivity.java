package com.udacity.gradle.builditbigger.androidLibrary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeViewActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_view);

        String joke = getIntent().getStringExtra(JOKE_KEY);
        TextView jokeTextView = (TextView) findViewById(R.id.joke_view);
        jokeTextView.setText(joke);
    }
}