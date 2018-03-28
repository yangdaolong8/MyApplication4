package com.example.strictmode;

import android.app.Application;
import android.os.StrictMode;

/**
 * Created by 11234567 on 2018/3/7.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskWrites()
                .detectDiskReads()
                .penaltyDialog()
                .build());
    }
}
