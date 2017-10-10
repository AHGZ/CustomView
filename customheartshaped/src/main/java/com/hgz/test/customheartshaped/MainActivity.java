package com.hgz.test.customheartshaped;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hgz.test.customheartshaped.custom.CustomHeartShaped;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomHeartShaped customHeartShaped = (CustomHeartShaped) findViewById(R.id.customHeartShaped);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);
        customHeartShaped.setBitmap(bitmap);

    }
}
