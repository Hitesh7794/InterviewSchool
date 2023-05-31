package com.example.interviewschool.activities;

import androidx.appcompat.app.AppCompatActivity;



import androidx.appcompat.app.AppCompatActivity;

import com.example.interviewschool.R;
import com.github.barteksc.pdfviewer.PDFView;
import android.os.Bundle;

public class CppAc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp);
        PDFView pdfView = findViewById(R.id.cpdf);
        pdfView.fromAsset("cpp.pdf").load();
    }
}