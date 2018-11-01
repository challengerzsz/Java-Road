#include <stdio.h>
#include "NativeMethod.h"

JNIEXPORT void JNICALL Java_NativeMethod_hello(JNIEnv *evn, jobject obj)
{
   printf("hello native method !!!");
}
