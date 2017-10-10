package com.hgz.test.customtriangle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hgz.test.customtriangle.custom.CustomTriangle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomTriangle customTriangle = (CustomTriangle) findViewById(R.id.customTriangle);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bagua);
        customTriangle.setBitmap(bitmap);
    }
}
