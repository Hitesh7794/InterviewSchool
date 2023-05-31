package com.example.interviewschool.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.interviewschool.R;
import com.example.interviewschool.databinding.ActivityOptionsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class OptionsAc extends AppCompatActivity {
    ActivityOptionsBinding binding;
    BottomNavigationView nav;
    Button btn ,interviewQa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityOptionsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_options);
        btn = findViewById(R.id.button1);
        nav = findViewById(R.id.bottom_navigation);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptionsAc.this,MainActivity.class));
            }
        });
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
                        startActivity(new Intent(OptionsAc.this,profileAc.class));
                        break;
                }
                return false;
            }
        });
        interviewQa = findViewById(R.id.button2);
        interviewQa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptionsAc.this,InterviewQaAc.class));
            }
        });
    }
}