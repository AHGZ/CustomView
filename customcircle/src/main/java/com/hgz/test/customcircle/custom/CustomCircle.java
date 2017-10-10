package com.hgz.test.customcircle.custom;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/10/9.
 */

public class CustomCircle extends Drawable {
    private Paint paint;
    private Bitmap bitmap;
    private int radius;
    public CustomCircle(Bitmap bitmap){
        this.bitmap=bitmap;
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        //着色器
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //原理就是我们把着色器给着色到paint上面
        //然后我们再绘制的时候就相当于paint上已经有图片了
        paint.setShader(shader);
        //需要拿到宽和高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //然后取最小值  是因为圆取最大值的话 图片很可能铺不满
        int min = Math.min(width, height);
        //得到半径
        radius=min/2;
    }
    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawCircle(radius,radius,radius,paint);
    }
    //透明度
    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
        paint.setAlpha(alpha);
    }
    //染缸
    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }
    //保持透明度
    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
    //实际宽
    @Override
    public int getIntrinsicWidth() {
        return radius*2;
    }
    //实际高
    @Override
    public int getIntrinsicHeight() {
        return radius*2;
    }
}
