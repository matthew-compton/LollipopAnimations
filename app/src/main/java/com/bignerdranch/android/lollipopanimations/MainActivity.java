package com.bignerdranch.android.lollipopanimations;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFrameAnimations = (Button) findViewById(R.id.button_frame_animations);
        buttonFrameAnimations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFrameAnimations = new Intent(MainActivity.this, FrameAnimationsActivity.class);
                startActivity(intentFrameAnimations);
            }
        });

        Button buttonRevealAnimations = (Button) findViewById(R.id.button_reveal_animations);
        buttonRevealAnimations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRevealAnimations = new Intent(MainActivity.this, RevealAnimationsActivity.class);
                startActivity(intentRevealAnimations);
            }
        });

        Button buttonRippleEffects = (Button) findViewById(R.id.button_ripple_effects);
        buttonRippleEffects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRippleEffects = new Intent(MainActivity.this, RippleEffectsActivity.class);
                startActivity(intentRippleEffects);
            }
        });

        Button buttonLinearMotionEffects = (Button) findViewById(R.id.button_linear_motion_effects);
        buttonLinearMotionEffects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLinearMotionEffects = new Intent(MainActivity.this, LinearMotionEffectsActivity.class);
                startActivity(intentLinearMotionEffects);
            }
        });

        Button buttonCurvedMotionEffects = (Button) findViewById(R.id.button_curved_motion_effects);
        buttonCurvedMotionEffects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCurvedMotionEffects = new Intent(MainActivity.this, CurvedMotionEffectsActivity.class);
                startActivity(intentCurvedMotionEffects);
            }
        });

        Button buttonSharedElementTransitions = (Button) findViewById(R.id.button_shared_element_transitions);
        buttonSharedElementTransitions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSharedElementTransitions = new Intent(MainActivity.this, SharedElementTransitionsSmallActivity.class);
                startActivity(intentSharedElementTransitions);
            }
        });

        Button buttonTransitions = (Button) findViewById(R.id.button_transitions);
        buttonTransitions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                    Intent intent = new Intent(MainActivity.this, TransitionsActivity.class);
                    startActivity(intent, options.toBundle());
                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            getWindow().setReenterTransition(new Fade());
        }

    }

}