package com.example.abhilash.jokedisplay;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    private static ProgressBar spinner;
    static TextView jokeTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        jokeTextView = (TextView) root.findViewById(R.id.joke_textview);
        spinner = (ProgressBar) root.findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);

        return root;
    }

    public static void prepareUI(String result) {


        if (jokeTextView != null && spinner != null) {
            jokeTextView.setText(result);
            spinner.setVisibility(View.GONE);
        }


    }


}

