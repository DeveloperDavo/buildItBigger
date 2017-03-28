package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.displaylib.DetailActivity;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        String result = executeEndpointsTask();
        startActivity(DetailActivity.newIntent(this, result));
    }

    private String executeEndpointsTask() {
        AsyncTask<Void, Void, String> asyncTask = new EndpointsAsyncTask().execute();
        String result;
        try {
            result = asyncTask.get();
        } catch (InterruptedException e) {
            result = "InterruptedException";
            Log.d(TAG, result, e);
        } catch (ExecutionException e) {
            result = "ExecutionException";
            Log.d(TAG, result, e);
        }
        return result;
    }


}
