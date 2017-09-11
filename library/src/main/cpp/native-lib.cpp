#include <jni.h>
#include "calculateBeerResult.h"


extern "C"
JNIEXPORT jintArray JNICALL
Java_message_license_szca_com_drinkbeer_presenter_CalculateBeerPresenter_getCalculateResult(
        JNIEnv *env,
        jobject /* this */,
        int money) {


    int *result =  calculateBeerResult(money);
    int size = sizeof(result);

    jintArray arry = env->NewIntArray(size);
    env->SetIntArrayRegion(arry, 0, size, result);

    return arry;
}

