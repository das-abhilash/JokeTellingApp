package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.JokeWizard;
import com.example.abhilash.jokedisplay.JokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;



public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, R.string.ToastMsg, Toast.LENGTH_SHORT).show();

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

    public void tellJoke(View view){
            ShowJoke();
    }



/*
    httpPort = 8085
*/
   /* @ApiMethod(name = "getJoke")
    public MyJoke getJoke() {
        JokeWizard jokeWizard = new JokeWizard();
        String joke = jokeWizard.getJoke();
        MyJoke response = new MyJoke();
        response.setData(joke);

        return response;
    }*/

    public void ShowJoke(){
        Intent intent = new Intent(this, JokeActivity.class);
        JokeWizard jokeWizard = new JokeWizard();
        String joke = jokeWizard.getJoke();

        intent.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(intent);
        new EndpointsAsyncTask().execute(this);
    }

}
