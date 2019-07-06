package com.ckdtech.www.androidlearningapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;


public class InterviewQuesActivity extends AppCompatActivity {
    PDFView  book;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interviewques_main);

        book = (PDFView) findViewById(R.id.pdf);
        book.fromAsset("androidQues.pdf").load();
    }
}

