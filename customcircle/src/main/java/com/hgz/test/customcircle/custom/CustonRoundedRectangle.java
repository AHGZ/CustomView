package com.hgz.test.customcircle.custom;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/10/9.
 */

public class CustonRoundedRectangle extends Drawable{
    private Paint paint;
    private RectF rectF;
    private Bitmap bitmap;
    private final int width;
    private final int height;

    public CustonRoundedRectangle(Bitmap bitmap){
        this.bitmap=bitmap;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectF=new RectF();
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
    }
    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawRoundRect(rectF,50,50,paint);
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
    @Override
    public int getIntrinsicWidth() {
        return width;
    }

    @Override
    public int getIntrinsicHeight() {
        return height;
    }
    //限定范围
    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        rectF.set(left,top,right,bottom);
    }
}
