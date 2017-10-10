package com.hgz.test.customprogress;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.hgz.test.customprogress.custom.MyProgressBar;

public class MainActivity extends AppCompatActivity {
    private int i=0;
    private MyProgressBar myProgressBar;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //根据不通值来设定不同的颜色
            if(i<=25){
                myProgressBar.setColor(Color.GREEN);
                myProgressBar.setMinProgress(i);
            }else if(i<=50){
                myProgressBar.setColor(Color.parseColor("#FF0080"));
                myProgressBar.setMinProgress(i);
            }else if(i<=75){
                myProgressBar.setColor(Color.BLUE);
                myProgressBar.setMinProgress(i);
            }else if(i<=100){
                myProgressBar.setColor(Color.YELLOW);
                myProgressBar.setMinProgress(i);
            }else{
                i=100;
            }
            handler.sendEmptyMessageDelayed(i++,300);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myProgressBar = (MyProgressBar) findViewById(R.id.myProgressBar);
        myProgressBar.setMaxProgress(100);
        //通过handler来无线发送消息 正长情况下为了减少内存泄漏需要在生命周期结束的时候把消息清空
        handler.sendEmptyMessage(i++);
    }
}
