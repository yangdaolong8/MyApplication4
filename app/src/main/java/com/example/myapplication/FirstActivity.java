package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 11234567 on 2018/3/21.
 */

public class FirstActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
