package com.hgz.test.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hgz.test.customview.view.MyTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyTextView myTextView = new MyTextView(this);
    }
}
