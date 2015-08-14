package com.bignerdranch.android.lollipopanimations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SharedElementTransitionsSmallActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_transitions_small);

        mImageView = (ImageView) findViewById(R.id.activity_shared_element_transitions_small_image);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SharedElementTransitionsSmallActivity.this, SharedElementTransitionsLargeActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        SharedElementTransitionsSmallActivity.this,
                        mImageView,
                        getString(R.string.shared_element_transition)
                );
                ActivityCompat.startActivity(SharedElementTransitionsSmallActivity.this, intent, options.toBundle());
            }
        });

    }

}