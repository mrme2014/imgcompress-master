package com.mrs.imgcompress;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.qiaomu.libcompress.ImageCompress;

import java.io.File;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of img call to img native method
        file = new File(Environment.getExternalStorageDirectory(), "compress.png");
        if (file.exists())
            file.delete();

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri uri = data.getData();
        ContentResolver cr = getContentResolver();
        try {
            Bitmap bmp = BitmapFactory.decodeStream(cr.openInputStream(uri));
            ImageCompress.compressBitmap(bmp, 20, Environment.getExternalStorageDirectory() + File.separator + "3_1.png");
            Log.e("onActivityResult: ","exits" );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e("onActivityResult: ","exception" );
        }

    }
}
