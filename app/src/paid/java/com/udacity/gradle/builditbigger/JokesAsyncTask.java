package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.androidLibrary.JokeViewActivity;
import com.udacity.gradle.builditbigger.gcemodule.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.gcemodule.jokeApi.model.JokeBean;

import java.io.IOException;

public class JokesAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static JokeApi myApiService = null;
    private Context mContext;
    private String mResult;
    private ProgressBar mProgressBar;

    public JokesAsyncTask(Context context, ProgressBar progressBar) {
        this.mContext = context;
        this.mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        if (myApiService == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://testandroiddevelopment.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        try {
            return myApiService.sendJoke(new JokeBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        mResult = result;
        startJokeDisplayActivity();
    }

    private void startJokeDisplayActivity() {

        Intent intent = new Intent(mContext, JokeViewActivity.class);
        intent.putExtra(JokeViewActivity.JOKE_KEY, mResult);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}