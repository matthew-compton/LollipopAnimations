package com.bignerdranch.android.lollipopanimations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class FrameAnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animations);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ImageView frameAnimationImageView =
                (ImageView) findViewById(R.id.activity_frame_animations_imageview);
        frameAnimationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameAnimationImageView.setActivated(!frameAnimationImageView.isActivated());
            }
        });

    }

}