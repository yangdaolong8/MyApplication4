package com.example.myapplication;

/**
 * Created by 11234567 on 2018/3/23.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    /** Debug Log tag*/
    public static final String TAG = "CrashHandler";

    /** CrashHandler实例 */
    private static CrashHandler INSTANCE;
    private static Object syncRoot = new Object();

    /** 保证只有一个CrashHandler实例 */
    private CrashHandler() {}

    /** 获取CrashHandler实例 ,单例模式*/
    public static CrashHandler getInstance() {
        // 防止多线程访问安全，这里使用了双重锁
        if (INSTANCE == null) {
            synchronized (syncRoot) {
                if (INSTANCE == null) {
                    INSTANCE =  new CrashHandler();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
/*        if (!handleException(ex) && mDefaultHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            //Sleep一会后结束程序
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Log.e(TAG, "Error : ", e);
            }
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(10);
        }*/
    }
}
