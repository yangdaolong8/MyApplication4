package com.example.myapplication;

/**
 * Created by 11234567 on 2018/2/8.
 */

public class JNI {
    static {
        System.loadLibrary("hello-jni");
    }

    public static native String helloFromC();
}
