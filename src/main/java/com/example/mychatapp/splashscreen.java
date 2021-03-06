package com.example.mychatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

@SuppressLint("CustomSplashScreen")
public class splashscreen extends AppCompatActivity {
    private static final int  SPLASH_TIMER= 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(() -> {

            Intent intent=new Intent(splashscreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        },SPLASH_TIMER);

    }
}