package com.bignerdranch.android.lollipopanimations;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class LinearMotionEffectsActivity extends AppCompatActivity {

    private Button mLinearMotionEffectsButton1;
    private Button mLinearMotionEffectsButton2;
    private Button mLinearMotionEffectsButton3;
    private ImageView mImageView;

    private boolean mIsShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_motion_effects);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mIsShowing = true;
        mImageView = (ImageView) findViewById(R.id.activity_linear_motion_effects_image);

        mLinearMotionEffectsButton1 = (Button) findViewById(R.id.activity_linear_motion_effects_button_1);
        mLinearMotionEffectsButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView.setVisibility(View.VISIBLE);
                if (mIsShowing) {
                    hide1();
                } else {
                    show1();
                }
                mIsShowing = !mIsShowing;
            }
        });

        mLinearMotionEffectsButton2 = (Button) findViewById(R.id.activity_linear_motion_effects_button_2);
        mLinearMotionEffectsButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIsShowing) {
                    hide2();
                } else {
                    show2();
                }
                mIsShowing = !mIsShowing;
            }
        });

        mLinearMotionEffectsButton3 = (Button) findViewById(R.id.activity_linear_motion_effects_button_3);
        mLinearMotionEffectsButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView.setVisibility(View.VISIBLE);
                if (mIsShowing) {
                    hide3();
                } else {
                    show3();
                }
                mIsShowing = !mIsShowing;
            }
        });
    }


    private void show1() {
        updateText(R.string.hide);
        mImageView.animate().translationX(0);
    }

    private void hide1() {
        updateText(R.string.show);
        int width = getResources().getDisplayMetrics().widthPixels;
        mImageView.animate().translationX(width);
    }

    private void show2() {
        updateText(R.string.hide);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.activity_linear_motion_slide_left);
        mImageView.startAnimation(animation);
        mImageView.setVisibility(View.VISIBLE);
    }

    private void hide2() {
        updateText(R.string.show);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.activity_linear_motion_slide_right);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mImageView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImageView.startAnimation(animation);
    }

    private void show3() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            updateText(R.string.hide);
            float startingX = mImageView.getX();
            float startingY = mImageView.getY();
            float endingX = startingX - (float) getResources().getDisplayMetrics().widthPixels;
            float endingY = startingY;

            Path path = new Path();
            path.moveTo(startingX, startingY);
            path.lineTo(endingX, endingY);
            path.moveTo(endingX, endingY);
            path.close();

            ObjectAnimator animator = ObjectAnimator.ofFloat(mImageView, View.X, View.Y, path);
            animator.setDuration(500);
            animator.start();
        }
    }

    private void hide3() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            updateText(R.string.show);
            float startingX = mImageView.getX();
            float startingY = mImageView.getY();
            float endingX = startingX + (float) getResources().getDisplayMetrics().widthPixels;
            float endingY = startingY;

            Path path = new Path();
            path.moveTo(startingX, startingY);
            path.lineTo(endingX, endingY);
            path.moveTo(endingX, endingY);
            path.close();

            ObjectAnimator animator = ObjectAnimator.ofFloat(mImageView, View.X, View.Y, path);
            animator.setDuration(500);
            animator.start();
        }
    }

    private void updateText(int stringResId) {
        mLinearMotionEffectsButton1.setText(stringResId);
        mLinearMotionEffectsButton2.setText(stringResId);
        mLinearMotionEffectsButton3.setText(stringResId);
    }

}