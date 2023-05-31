package com.example.interviewschool.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.interviewschool.R;
import com.google.firebase.auth.FirebaseAuth;

public class splashAc extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView = findViewById(R.id.imageView);
        TextView crack_it = findViewById(R.id.crack_it);

        //Set ImageView alpha to zero
        imageView.setAlpha(0f);
        imageView.setTranslationX(100);
        crack_it.setAlpha(0f);
        crack_it.setTranslationX(0);


        imageView.animate().alpha(1f).translationXBy(-50).setDuration(1600);
        crack_it.animate().alpha(1f).translationXBy(40).setDuration(1600);

        mAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mAuth.getCurrentUser() != null) {
                    startActivity(new Intent(splashAc.this, OptionsAc.class));
                } else {
                    startActivity(new Intent(splashAc.this, LoginAc.class));
                }
                finish();
            }
        }, 2500);

    }
}