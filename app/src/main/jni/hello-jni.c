//
// Created by 11234567 on 2018/2/8.
//

#include "hello-jni.h"
#include "com_example_myapplication_JNI.h"

JNIEXPORT jstring JNICALL Java_com_example_myapplication_JNI_helloFromC(JNIEnv *env, jclass obj)

{

    char buf[] = "HEllO JNI";

    return (*env)->NewStringUTF(env,buf);

}
