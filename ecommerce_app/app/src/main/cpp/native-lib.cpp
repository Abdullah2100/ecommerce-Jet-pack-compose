#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_core_domain_Secrets_getStripKey(JNIEnv *env, jobject thiz) {
    std::string baseUrl = "pk_test_22Sm8GfHSWpeb01zOzUpuMfN9DResnK59fYyWMbB9vAJPIk6Epo7owMlmrWGTU9wJA6UifuGjEjCl1UuAp0LmJ2Yd00eQxDQmeA";
    return env->NewStringUTF(baseUrl.c_str());
}