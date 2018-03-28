package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends Activity {
    private Context mContext;

    private TextView tvTest;
    private Button btTest1;
    private AlertDialog alertDialog;

    static {
        System.loadLibrary("hello-jni");
    }

    private final Handler mHandler = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        //JNI jni = new JNI();
        //Toast.makeText(mContext, jni.helloFromC(), Toast.LENGTH_SHORT).show();

        btTest1 = (Button) findViewById(R.id.bt_test1);
        btTest1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i = new Intent(mContext, FirstActivity.class);
                   startActivity(i);
               }
           }
        );

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    private static class MyHandler extends Handler {
        private final WeakReference<Activity> mActivityReference;

        public MyHandler(Activity activity) {
            mActivityReference = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {

            final Activity activity = mActivityReference.get();
            if (activity != null) {

            }
        }
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("this is the content view!!!");
        builder.setTitle("this is the title view!!!");
        builder.setView(R.layout.activity_second);
        builder.setPositiveButton("知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
