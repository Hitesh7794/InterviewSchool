package com.example.interviewschool.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.interviewschool.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;

public class InterviewQaAc extends AppCompatActivity {
    GridView coursesGV;
    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_qa);

        coursesGV = findViewById(R.id.idGVcourses);
        ArrayList<Coursemodel> courseModelArrayList = new ArrayList<Coursemodel>();

        courseModelArrayList.add(new Coursemodel("DSA", R.drawable.structure));
        courseModelArrayList.add(new Coursemodel("JAVA", R.drawable.java));
        courseModelArrayList.add(new Coursemodel("C++", R.drawable.cpp));
        courseModelArrayList.add(new Coursemodel("Python", R.drawable.python));
        courseModelArrayList.add(new Coursemodel("Javascript", R.drawable.js));
        courseModelArrayList.add(new Coursemodel("DBMS", R.drawable.dbms));

        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);
        coursesGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*Intent intent = new Intent(InterviewQaAc.this,Questions.class);
                intent.putExtra("course_name",courseModelArrayList.get(i).getCourse_name());
                startActivity(intent);*/
                String sub = courseModelArrayList.get(i).getCourse_name();
                if(sub == "C++"){
                    startActivity(new Intent(InterviewQaAc.this, CppAc.class));
                }
                else if(sub=="JAVA"){
                    startActivity(new Intent(InterviewQaAc.this, JavaAc.class));
                }else if(sub=="DBMS"){
                    startActivity(new Intent(InterviewQaAc.this, DatabaseAc.class));
                }else if(sub=="Python"){
                    startActivity(new Intent(InterviewQaAc.this, PythonAc.class));
                }else if(sub=="DSA"){
                    startActivity(new Intent(InterviewQaAc.this, DsaAc.class));
                }else if(sub=="Javascript"){
                    startActivity(new Intent(InterviewQaAc.this, JavaScriptAc.class));
                }
            }
        });
        nav = findViewById(R.id.bottom_navigation);
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
                        startActivity(new Intent(InterviewQaAc.this,profileAc.class));
                        break;
                    case R.id.home:
                        startActivity(new Intent(InterviewQaAc.this,OptionsAc.class));
                        break;
                }
                return false;
            }
        });

    }
}