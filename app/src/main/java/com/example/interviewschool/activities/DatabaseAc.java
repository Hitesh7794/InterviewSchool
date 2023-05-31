package com.example.interviewschool.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.interviewschool.R;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
public class DatabaseAc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        PDFView pdfView = findViewById(R.id.dpdf);
        pdfView.fromAsset("dbms.pdf").load();
    }
}