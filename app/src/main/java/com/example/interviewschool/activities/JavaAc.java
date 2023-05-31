package com.example.interviewschool.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.interviewschool.R;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
public class JavaAc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        PDFView pdfView=findViewById(R.id.jpdf);
        pdfView.fromAsset("jq.pdf").load();
    }
}