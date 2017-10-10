package com.hgz.test.customrectangle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.hgz.test.customrectangle.custom.CustomRectangle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView rectangleImage = (ImageView) findViewById(R.id.rectangleImage);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bagua);
        rectangleImage.setImageDrawable(new CustomRectangle(bitmap));
    }
}
