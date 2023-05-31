package com.example.interviewschool.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.interviewschool.R;
import com.github.barteksc.pdfviewer.PDFView;
public class PythonAc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);
        PDFView pdfView = findViewById(R.id.pypdf);
        pdfView.fromAsset("pythonQues.pdf").load();
    }
}