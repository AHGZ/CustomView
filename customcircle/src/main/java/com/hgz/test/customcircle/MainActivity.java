package com.hgz.test.customcircle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.hgz.test.customcircle.custom.CustomCircle;

public class MainActivity extends AppCompatActivity {

    private ImageView circleImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleImage = (ImageView) findViewById(R.id.circleImage);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bagua);
        circleImage.setImageDrawable(new CustomCircle(bitmap));

    }
}
