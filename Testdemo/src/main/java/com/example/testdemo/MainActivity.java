package com.example.testdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btQuickSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
        btQuickSort = (Button) findViewById(R.id.bt_quick_sort);
        btQuickSort.setOnClickListener(this);
    }

    private void testHandlerThread() {
        HandlerThread mHandlerThread = new HandlerThread("handlerThread");

        mHandlerThread.start();

        Handler workHandler = new Handler(mHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.bt_quick_sort:
            //快速排序
            int[] a = new int[]{2,7,4,5,10,1,9,3,8,6};
            int[] b = new int[]{1,2,3,4,5,6,7,8,9,10};
            int[] c = new int[]{10,9,8,7,6,5,4,3,2,1};
            int[] d = new int[]{1,10,2,9,3,2,4,7,5,6};

            QuickSort.sort(a, 0, a.length-1);

            System.out.println("排序后的结果：");
            for(int x : a){
                System.out.print(x+" ");
            }
            break;
        default:
            break;
        }
    }

}
