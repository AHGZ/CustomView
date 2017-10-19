package com.hgz.test.onmeasureonmeasureview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/10/19.
 */

public class MyView extends View{
    private int viewWidth=50;
    private int viewHeight=50;
    private int mRadius=10;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthResult=0;
        int heightResult=0;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);//取出宽度的测量模式
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);//取出宽度的大小

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);//取出高度的测量模式
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);//取出高度的大小

        if (widthMode==MeasureSpec.AT_MOST){
            widthResult=Math.min(viewWidth,widthSize);
        }else{
            widthResult=widthSize;
        }
        if (heightMode==MeasureSpec.AT_MOST){
            heightResult=Math.min(viewHeight,heightSize);
        }else{
            heightResult=heightSize;
        }
        setMeasuredDimension(widthResult,heightResult);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mRadius=mRadius+5;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        canvas.drawCircle(getWidth()/2,getHeight()/2,mRadius,paint);
    }
    public void changeSize(int width,int height){
        viewWidth=viewWidth+width;
        viewHeight=viewHeight+height;
        //重新绘制
        requestLayout();
    }
}
