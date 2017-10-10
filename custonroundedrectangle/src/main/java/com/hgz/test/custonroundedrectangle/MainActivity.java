package com.hgz.test.custonroundedrectangle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.hgz.test.custonroundedrectangle.custom.CustonRoundedRectangle;

public class MainActivity extends AppCompatActivity {
    private ImageView roundedRectangleImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roundedRectangleImage = (ImageView) findViewById(R.id.roundedRectangleImage);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bagua);
        roundedRectangleImage.setImageDrawable(new CustonRoundedRectangle(bitmap));
    }
}
