package com.hgz.test.onlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wxn on 2017/10/19.
 */

public class ArcLayout extends ViewGroup {
    private float layoutRadius = 200;

    public ArcLayout(Context context) {
        super(context);
    }

    public ArcLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArcLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int count = getChildCount();
        for (int i = 0; i < count; i++) {

            measureChild(getChildAt(i),widthMeasureSpec,heightMeasureSpec);
        }
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {


        int count = getChildCount();
        for (int i = 0; i < count; i++) {

            View childView = getChildAt(i);

            int cx = getWidth()/2;
            int cy = getHeight()/2;

            int childCX = (int) (cx + layoutRadius*Math.sin(Math.toRadians(360)/count*i));
            int childCY = (int) (cy + layoutRadius*Math.cos(Math.toRadians(360)/count*i));


            int top = childCY - childView.getMeasuredHeight()/2;
            int left = childCX - childView.getMeasuredWidth()/2;
            int right = left + childView.getMeasuredWidth();
            int bottom = top + childView.getMeasuredHeight();

            childView.layout(left,top,right,bottom);



        }

    }
}
