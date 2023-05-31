package com.example.interviewschool.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.interviewschool.R;
import com.github.barteksc.pdfviewer.PDFView;

public class JavaScriptAc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_script);
        PDFView pdfView = findViewById(R.id.scrpdf);
        pdfView.fromAsset("javascr.pdf").load();
    }
}