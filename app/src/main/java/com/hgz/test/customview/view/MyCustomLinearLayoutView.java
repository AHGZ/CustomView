package com.hgz.test.customview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.hgz.test.customview.R;

/**
 * Created by Administrator on 2017/8/30.
 */

public class MyCustomLinearLayoutView extends LinearLayout {
    public MyCustomLinearLayoutView(Context context) {
        super(context);
        initView(context);
    }

    public MyCustomLinearLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }
    private void initView(Context context){
        View inflate = inflate(context, R.layout.linearlayout_view, this);
    }
}
