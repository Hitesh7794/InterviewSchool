package com.example.interviewschool.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.interviewschool.R;
import com.google.firebase.auth.FirebaseAuth;


public class welcomeAc extends AppCompatActivity {
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_welcome);
        auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() != null) {
            goToNextActivity();
        }

        findViewById(R.id.getStarted).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              goToNextActivity();
            }
        });
    }

    void goToNextActivity() {
        startActivity(new Intent(welcomeAc.this, LoginAc.class));
        finish();
    }

}