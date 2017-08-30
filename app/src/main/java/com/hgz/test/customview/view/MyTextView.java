package com.hgz.test.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hgz.test.customview.R;

/**
 * Created by Administrator on 2017/8/30.
 */

public class MyTextView extends View {

    private String text;
    private int textcolor;
    private float textSize;

    public MyTextView(Context context) {
        super(context);
        initAttrs(null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }
    private void initAttrs(@Nullable AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView);
        text = typedArray.getString(R.styleable.MyTextView_text);
        textcolor = typedArray.getColor(R.styleable.MyTextView_textColor,000000);
        textSize = typedArray.getDimension(R.styleable.MyTextView_textSize, 20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(textcolor);
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        canvas.drawText(text,10,100,paint);
    }
}
