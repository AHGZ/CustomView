package com.hgz.test.customwaterripple.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.hgz.test.customwaterripple.MyShuiBoWen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */

public class CustomWaterRipple extends View{
    //用来保存圆的集合
    private List<MyShuiBoWen> list=new ArrayList<>();
    public CustomWaterRipple(Context context) {
        this(context,null);
    }

    public CustomWaterRipple(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomWaterRipple(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //判断如果集合里有数据就开始画圆
        if(list.size()>0){
            drawcicle(canvas);

        }
    }
    private void drawcicle(Canvas canvas) {
//通过遍历拿到每一个圆
        for (int i=0;i<list.size();i++){
            MyShuiBoWen shuiBoWen = list.get(i);
            //绘制圆形
            canvas.drawCircle(shuiBoWen.X,shuiBoWen.Y,shuiBoWen.radius,shuiBoWen.paint);
            shuiBoWen.radius+=2;//让图的半径自增  增长幅度自己决定
            int alpha = shuiBoWen.paint.getAlpha();//得到圆的透明度
            if(alpha<150){//小于150是为了效果显示 具体没意义 因为值越小越透明
                alpha=0;
            }else{
                alpha--;
            }
            shuiBoWen.paint.setAlpha(alpha);
            shuiBoWen.paint.setStrokeWidth(shuiBoWen.radius/8);
            invalidate();//因为是画了N个圆 等于一直在画 所以重新绘制
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //得到点击的做标来生成相应的shuibowen
                float x = event.getX();
                float y = event.getY();
                delete();//我们在每次添加之前先把透明度是0的给清除掉
                MyShuiBoWen shuiBoWen = new MyShuiBoWen(x, y);
                list.add(shuiBoWen);
                invalidate();//因为现在集合里有圆了  所以需要重新走Ondraw()方法 所以重新绘制
                break;
            case MotionEvent.ACTION_MOVE:
                //同上
                float x2 = event.getX();
                float y2 = event.getY();
                delete();
                MyShuiBoWen shuiBoWen2 = new MyShuiBoWen(x2, y2);
                list.add(shuiBoWen2);
                invalidate();
                break;
        }
        return true;
    }
    //删除透明度为0的数据
    private void delete() {
        for (int i=0;i<list.size();i++){
            MyShuiBoWen shuiBoWen = list.get(i);
            if(shuiBoWen.paint.getAlpha()==0){
                list.remove(i);
            }
        }


    }
}
