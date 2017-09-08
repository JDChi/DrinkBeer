//
// Created by edao on 2017/9/8.
//

#include "jni.h"
#include "string.h"

JNIEXPORT jstring JNICALL
Java_message_license_szca_com_drinkbeer_CalculateBeerActivity_getBeer(
        JNIEnv *env,
jint money) {

    char* a = "hello";




    return (*env)->NewStringUTF(env , a);
}

