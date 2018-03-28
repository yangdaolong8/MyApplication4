package com.example.jnitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.JNI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JNI jni = new JNI();
        Toast.makeText(this, jni.helloFromC(), Toast.LENGTH_SHORT).show();
    }
}
