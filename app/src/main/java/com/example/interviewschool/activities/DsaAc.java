package com.example.interviewschool.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.interviewschool.R;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
public class DsaAc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsa);
        PDFView pdfView = findViewById(R.id.dsapdf);
        pdfView.fromAsset("dsa.pdf").load();
    }
}