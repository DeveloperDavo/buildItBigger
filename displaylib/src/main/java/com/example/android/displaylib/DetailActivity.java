package com.example.android.displaylib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tvJoke = (TextView) findViewById(R.id.tv_joke);
        tvJoke.setText(getIntent().getStringExtra(JOKE));

    }

    public static Intent newIntent(Context context, String joke) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(JOKE, joke);
        return intent;
    }
}
