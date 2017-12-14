#ifndef COMPRESS_COMPRESS_H_H
#define COMPRESS_COMPRESS_H_H

#include "lang.h"
#include <stdlib.h>
#include <android/bitmap.h>

#include <setjmp.h>
#include <jpeglib.h>

#define true 1
#define false 0

JNIEXPORT jint JNICALL
Java_com_mrs_imgcompress_ImageCompress_compressBitmap(JNIEnv *env, jclass type,
                                                               jobject bitmap, jint quality,
                                                               jstring dstFile_);
#endif
