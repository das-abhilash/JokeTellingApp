package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ActivityUnitTestCase;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Abhilash on 4/24/2016.
 */
public class AsyncTaskTest extends ApplicationTestCase<Application> {
    String mResult = null;
    CountDownLatch signal = null;

    public AsyncTaskTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testEndpointsAsyncTask() throws InterruptedException {

        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.setListener(new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
            @Override
            public void onComplete(String result) {
                mResult = result;

                signal.countDown();
            }
        }).execute(getContext());
        signal.await();

        assertNotNull(mResult);
        assertEquals("Apparently I snore so loudly that it scares everyone in the car I'm driving.",
                mResult);


    }
}
