package com.hgz.test.customcircle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.hgz.test.customcircle.custom.CustomCircle;
import com.hgz.test.customcircle.custom.CustonRoundedRectangle;

public class MainActivity extends AppCompatActivity {

    private ImageView circleImage;
    private ImageView roundedRectangleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleImage = (ImageView) findViewById(R.id.circleImage);
        roundedRectangleImage = (ImageView) findViewById(R.id.roundedRectangleImage);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bagua);
        circleImage.setImageDrawable(new CustomCircle(bitmap));
        roundedRectangleImage.setImageDrawable(new CustonRoundedRectangle(bitmap));
    }
}
