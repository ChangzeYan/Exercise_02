package com.example.administrator.exercise_02;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by lenovo on 2017/3/16.
 */

public class attrs extends AppCompatActivity {
    Button stop;
    Button start;
    Button restart;
    private TimeCount time;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_down);
        time=new TimeCount(60000,1000);
        start = (Button) findViewById(R.id.start_btn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.start();
            }
        });
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
            start.setText(millisUntilFinished/1000+"秒");
        }
    }
}
