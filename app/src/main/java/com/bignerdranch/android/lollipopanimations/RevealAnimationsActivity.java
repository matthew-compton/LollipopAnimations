package com.bignerdranch.android.lollipopanimations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class RevealAnimationsActivity extends AppCompatActivity {

    private Button mRevealAnimationButton;
    private ImageView mImageView;

    private boolean mIsShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_animations);

        mIsShowing = true;
        mImageView = (ImageView) findViewById(R.id.activity_reveal_animations_image);
        mRevealAnimationButton = (Button) findViewById(R.id.activity_reveal_animations_button);
        mRevealAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIsShowing) {
                    mRevealAnimationButton.setText(R.string.show);
                    hide();
                } else {
                    mRevealAnimationButton.setText(R.string.hide);
                    show();
                }
                mIsShowing = !mIsShowing;
            }
        });

    }

    private void show() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cx = mImageView.getMeasuredWidth() / 2;
            int cy = mImageView.getMeasuredHeight() / 2;
            int initialRadius = 0;
            int finalRadius = Math.max(mImageView.getWidth(), mImageView.getHeight()) / 2;
            Animator anim = ViewAnimationUtils.createCircularReveal(mImageView, cx, cy, initialRadius, finalRadius);
            mImageView.setVisibility(View.VISIBLE);
            anim.start();
        } else {
            mImageView.setVisibility(View.VISIBLE);
        }
    }

    private void hide() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cx = mImageView.getMeasuredWidth() / 2;
            int cy = mImageView.getMeasuredHeight() / 2;
            int initialRadius = mImageView.getWidth() / 2;
            int finalRadius = 0;
            Animator anim = ViewAnimationUtils.createCircularReveal(mImageView, cx, cy, initialRadius, finalRadius);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mImageView.setVisibility(View.INVISIBLE);
                }
            });
            anim.start();
        } else {
            mImageView.setVisibility(View.INVISIBLE);
        }
    }

}