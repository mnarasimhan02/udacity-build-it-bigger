package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

public class CloudModuleTest extends AndroidTestCase {

    public void runCloudModuleTest() {
        String joke = null;
        JokesAsyncTask jokesAsyncTask = new JokesAsyncTask(getContext(), null);
        jokesAsyncTask.execute();
        try {
            joke = jokesAsyncTask.get();
            Log.d("CloudModuleTest", "Retrieved a non-empty string successfully: " + joke);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(joke);
    }

}
