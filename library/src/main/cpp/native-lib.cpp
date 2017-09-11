#include <jni.h>
/**
 * 返回一个int数组
 * 第一个数表示已经喝的瓶数
 * 第二个数表示剩下的空瓶子
 * 第三个数表示剩下的盖子
 */
extern "C"
JNIEXPORT jintArray JNICALL
Java_message_license_szca_com_drinkbeer_presenter_CalculateBeerPresenter_getCalculateResult(
        JNIEnv *env,
        jobject /* this */,
        int money) {

    //总价格
    int allMoney = money;
    //已经喝的瓶数
    int drunkBottle = allMoney / 2;
    //剩下的空瓶子
    int emptyBottle = drunkBottle;
    //剩下的瓶盖
    int top = drunkBottle;
    int size = 3;
    int result[size];


    while (emptyBottle >= 2 || top >= 4) {
        int tmp = emptyBottle / 2 + top / 4;
        drunkBottle = drunkBottle + tmp;
        emptyBottle = tmp + emptyBottle % 2;
        top = tmp + top % 4;
    }

    result[0] = drunkBottle;
    result[1] = emptyBottle;
    result[2] = top;

    jintArray arry = env->NewIntArray(size);
    env->SetIntArrayRegion(arry, 0, size, result);

    return arry;
}
