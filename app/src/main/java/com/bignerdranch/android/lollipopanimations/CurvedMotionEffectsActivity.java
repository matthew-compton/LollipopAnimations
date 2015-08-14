package com.bignerdranch.android.lollipopanimations;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CurvedMotionEffectsActivity extends AppCompatActivity {

    private Button mCurvedMotionEffectsButton;
    private ImageView mImageView;

    private boolean mIsShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curved_motion_effects);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mIsShowing = true;
        mImageView = (ImageView) findViewById(R.id.activity_curved_motion_effects_image);

        mCurvedMotionEffectsButton = (Button) findViewById(R.id.activity_curved_motion_effects_button);
        mCurvedMotionEffectsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView.setVisibility(View.VISIBLE);
                if (mIsShowing) {
                    hide();
                } else {
                    show();
                }
                mIsShowing = !mIsShowing;
            }
        });

    }


    private void show() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mCurvedMotionEffectsButton.setText(R.string.hide);
            float startingX = mImageView.getX();
            float startingY = mImageView.getY();
            float endingX = startingX - (float) getResources().getDisplayMetrics().widthPixels;
            float endingY = startingY;
            float middleX = (startingX + endingX) / 2;
            float middleY = startingY + 300;

            Path path = new Path();
            path.moveTo(startingX, startingY);
            path.cubicTo(startingX, startingY, middleX, middleY, endingX, endingY);
            path.moveTo(endingX, endingY);
            path.close();

            ObjectAnimator animator = ObjectAnimator.ofFloat(mImageView, View.X, View.Y, path);
            animator.setDuration(500);
            animator.start();
        }
    }

    private void hide() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mCurvedMotionEffectsButton.setText(R.string.show);
            float startingX = mImageView.getX();
            float startingY = mImageView.getY();
            float endingX = startingX + (float) getResources().getDisplayMetrics().widthPixels;
            float endingY = startingY;
            float middleX = (startingX + endingX) / 2;
            float middleY = startingY - 300;

            Path path = new Path();
            path.moveTo(startingX, startingY);
            path.cubicTo(startingX, startingY, middleX, middleY, endingX, endingY);
            path.moveTo(endingX, endingY);
            path.close();

            ObjectAnimator animator = ObjectAnimator.ofFloat(mImageView, View.X, View.Y, path);
            animator.setDuration(500);
            animator.start();
        }
    }

}