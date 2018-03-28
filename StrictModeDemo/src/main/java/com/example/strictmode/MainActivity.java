package com.example.strictmode;

import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectNetwork()
                .penaltyLog()
                .build());*/

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskWrites()
                .detectDiskReads()
                .penaltyLog()
                .build());

        btnTest = (Button) findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNetwork();
                postNetwork();
                Log.i(TAG, "测试");
                //writeToExternalStorage();
            }
        });

        HashMap<String, String> map = new HashMap<>();
    }

    /**
     * 网络连接的操作
     */
    private void postNetwork() {
        try {
            URL url = new URL("http://www.wooyun.org");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String lines = null;
            StringBuffer sb = new StringBuffer();
            while ((lines = reader.readLine()) != null) {
                sb.append(lines);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件系统的操作
     */
    public void writeToExternalStorage() {
        File externalStorage = Environment.getExternalStorageDirectory();
        File mbFile = new File(externalStorage, "castiel.txt");
        try {
            OutputStream output = new FileOutputStream(mbFile, true);
            output.write("www.wooyun.org".getBytes());
            output.flush();
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
