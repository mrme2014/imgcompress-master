package com.qiaomu.libcompress;

import android.graphics.Bitmap;

/**
 * Created by mrs on 2017/5/23.
 */

public class ImageCompress {
    static {
        System.loadLibrary("compress");
    }
    private ImageCompress() {
    }
    public static native int compressBitmap(Bitmap bitmap, int quality, String fileName);
}
