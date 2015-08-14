package com.bignerdranch.android.lollipopanimations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SharedElementTransitionsLargeActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_transitions_large);

        mImageView = (ImageView) findViewById(R.id.activity_shared_element_transitions_large_image);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SharedElementTransitionsLargeActivity.this, SharedElementTransitionsSmallActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        SharedElementTransitionsLargeActivity.this,
                        mImageView,
                        getString(R.string.shared_element_transition)
                );
                ActivityCompat.startActivity(SharedElementTransitionsLargeActivity.this, intent, options.toBundle());
            }
        });

    }

}