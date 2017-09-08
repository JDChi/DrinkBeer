#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_message_license_szca_com_drinkbeer_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
