package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

public class CloudModuleTest extends AndroidTestCase {
    private static final String LOG_TAG = "CloudModuleTest";


    @SuppressWarnings("unchecked")

    public void runCloudModuleTest() {
        String joke = null;
        Log.v("NonEmptyStringTest", "Running NonEmptyStringTest test");
        JokesAsyncTask jokesAsyncTask = new JokesAsyncTask(getContext(), null);
        jokesAsyncTask.execute();
        try {
            joke = jokesAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + joke);

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(joke);
    }

}
