package com.example.administrator.exercise_02;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button list;
    private Button dialog;
    private Button register;
    private Button count_down;
    private Button fram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register=(Button)findViewById(R.id.change_page);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,page_02.class);
                startActivity(intent);
            }
        });
        list=(Button)findViewById(R.id.list);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,page_03.class);
                startActivity(intent);
            }
        });
        dialog=(Button)findViewById(R.id.dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,page_04.class));
            }
        });
        count_down=(Button)findViewById(R.id.count_down);
        count_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,attrs.class));
            }
        });
        fram=(Button)findViewById(R.id.fram);
        fram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainTabActivity.class));
            }
        });
    }
    public void click_change(View v){
        TextView txt=(TextView)findViewById(R.id.textView);
        txt.setText("你好");
        txt.setBackgroundColor(Color.BLUE);
    }
}
