package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import static junit.framework.Assert.*;

/**
 * Created by David on 12/03/2017.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Test
    public void test_resultIsNotEmpty() throws ExecutionException, InterruptedException {
        AsyncTask<Void, Void, String> asyncTask = new EndpointsAsyncTask().execute();
        String result = asyncTask.get();
        assertNotNull(result);
        assertNotSame("", result);
    }
}
