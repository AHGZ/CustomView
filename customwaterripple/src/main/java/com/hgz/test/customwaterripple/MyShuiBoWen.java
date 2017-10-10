package com.hgz.test.customwaterripple;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Administrator on 2017/10/10.
 */
//用于保存所要绘制圆的数据
public class MyShuiBoWen {
    public Paint paint;
    public float X;//x坐标
    public float Y;//y坐标
    public float stokewidth;//圆环宽度
    public int radius;//半径
    public int random;//随机数用来去颜色
    //颜色的数组用来给圆提供颜色
    private int[] colors=new int[]{Color.RED,Color.GREEN,Color.YELLOW,Color.BLUE,Color.WHITE,
            Color.parseColor("#FF0080"),Color.parseColor("#FF8000"),Color.parseColor("#FF8080"),Color.parseColor("#0080FF")};
    //有参构造
    public MyShuiBoWen(float X,float Y){
        this.X=X;
        this.Y=Y;
        initData();
    }
    //初始化所需要的数据
    private void initData() {
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAlpha(255);//设置透明的原因是因为 我们在移动的时候就会产生N个圆 所以要给他有限制 通过透明度
        random= (int) (Math.random()*9);
        paint.setColor(colors[random]);//设置颜色
        paint.setStrokeWidth(stokewidth);
        paint.setStyle(Paint.Style.STROKE);//画笔风格

    }
}
