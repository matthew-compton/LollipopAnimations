package com.bignerdranch.android.lollipopanimations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RippleEffectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple_effects);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}