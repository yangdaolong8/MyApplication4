package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 11234567 on 2018/3/21.
 */

public class SecondActivity extends Activity implements View.OnClickListener{
    private Button btTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
        btTest = (Button) findViewById(R.id.bt_test);

        btTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.bt_test:

            break;
        default:

            break;
        }
    }
}
