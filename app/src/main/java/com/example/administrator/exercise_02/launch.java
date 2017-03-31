package com.example.administrator.exercise_02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by lenovo on 2017/3/14.
 */

public class launch extends Activity {

    private TimeCount time;
    private Button start;
    boolean flag;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        flag=false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);
        time=new TimeCount(3000,1000);
        time.start();
        start = (Button) findViewById(R.id.launch_count);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(launch.this, MainActivity.class);
                startActivity(intent);
                flag=true;
            }
        });
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(launch.this, MainActivity.class);
                if(!flag)startActivity(intent);
                finish();
            }
        },3000);
    }
    class TimeCount extends CountDownTimer {
        public TimeCount(long millislnFuture,long countDownInterval){
            super(millislnFuture,countDownInterval);
        }

        @Override
        public void onFinish() {
            start.setText("欢迎！");
            start.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            start.setClickable(true);
            start.setText("点击跳过"+millisUntilFinished/1000+"秒");
        }
    }
}
