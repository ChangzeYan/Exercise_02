package com.example.administrator.exercise_02;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/3/15.
 */

public class page_04 extends AppCompatActivity {
    private Button circle;
    private Button tiao;
    private Button confirm;
    private Button list_choose;
    private Button single;
    private Button multiple;
    private Button define;
    private boolean flag;
    private TextView alert_tview;
    ArrayList<String>arrayList=new ArrayList<String>();
    String string="";
    String st="";
    final String []str={"苹果","芒果","橘子","香蕉"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_04);
        flag=false;
        arrayList.add("苹果");
        arrayList.add("芒果");
        arrayList.add("橘子");
        arrayList.add("香蕉");
        alert_tview=(TextView)findViewById(R.id.alert_tview);
    }
    public void circle_click(View view){
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("提示");
        progressDialog.setMessage("这是一个圆形进度条对话框");
        progressDialog.show();
    }

    public void tiao_click(View view){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("提示");
        progressDialog.setMax(100);
        progressDialog.setMessage("这是一个条形进度条对话框");
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++){
                    try{
                        Thread.sleep(1000);
                        progressDialog.setProgress(i);
                    }catch (Exception e){}
                }
            }
        }).start();
    }

    public void confirm_click(View view){
        flag=false;
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher).setTitle("退出提示").setMessage("确定要退出吗？").setCancelable(true).setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                flag=true;
            }
        });
        AlertDialog dialog=builder.show();
        if(flag)dialog.dismiss();
    }

    public void list_choose_click(View view){
        flag=false;
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher).setTitle("你喜欢吃哪种水果").setCancelable(true);
        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert_tview.setText("您喜欢的水果是："+str[which]);
            }
        });
        builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                flag=true;
                alert_tview.setText("AlertDialog");
            }
        });
        AlertDialog dialog=builder.show();
        if(flag)dialog.dismiss();
    }

    public void single_click(View view){
        flag=false;
        st="";
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("你喜欢吃哪种水果？").setIcon(R.mipmap.ic_launcher).setSingleChoiceItems(str, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                st=str[which];
            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert_tview.setText("您喜欢吃的水果是："+st);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                flag=true;
                alert_tview.setText("AlertDialog");
            }
        });
        AlertDialog dialog=builder.show();
        if(flag)dialog.dismiss();
    }

    public void multiple_click(View view){
        flag=false;
        string="";
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("你喜欢吃哪种水果？").setIcon(R.mipmap.ic_launcher).setMultiChoiceItems(str, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked)string+=str[which].toString()+"  ";
            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert_tview.setText("您喜欢吃的水果是："+string);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert_tview.setText("AlertDialog");
                flag=true;
            }
        });
        AlertDialog dialog=builder.show();
        if(flag)dialog.dismiss();
    }

    public void define_click(View view){
        flag=false;
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher).setTitle("填写个人信息").setView(R.layout.define_dialog).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //EditText editText=(EditText)findViewById(R.id.define_edtext);
                alert_tview.setText("提交成功");
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert_tview.setText("AlertDialog");
                flag=true;
            }
        });
        AlertDialog dialog=builder.show();
        if(flag)dialog.dismiss();
    }

}
