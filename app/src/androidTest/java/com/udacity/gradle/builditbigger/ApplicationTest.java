package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }

    private static final String LOG_TAG = "CloudModuleTest";
    String joke = null;
    Exception error = null;
    CountDownLatch pivot;

    @SuppressWarnings("unchecked")

    public void runCloudModuleTest() throws InterruptedException {
        pivot = new CountDownLatch(1);
        JokesAsyncTask jokesAsyncTask = new JokesAsyncTask(getContext(), null);
        jokesAsyncTask.setListener(new JokesAsyncTask.TaskListener() {
            @Override
            public void onComplete(String jokeText, Exception ex) {
                joke = jokeText;
                error = ex;
                pivot.countDown();
            }
        }).execute();
        pivot.await();

        assertNull(error);
        assertFalse(TextUtils.isEmpty(joke));
    }
}

