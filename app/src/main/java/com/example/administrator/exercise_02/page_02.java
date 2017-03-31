package com.example.administrator.exercise_02;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * Created by Administrator on 2017/3/4 0004.
 */

public class page_02 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_02);
        final Spinner spinner=(Spinner)findViewById(R.id.spinner);
        String []arr={"计算机科学与技术","软件工程","网络工程"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
        spinner.setAdapter(adapter);
        final EditText edit=(EditText)findViewById(R.id.editText);
        Button btn=(Button)findViewById(R.id.btn_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new AlertDialog.Builder(page_02.this).setTitle("提示框").setMessage("sfadf").show();
                String str="";
                //判断edit是否为空：TextUtils.isEmpty(edit.getText())
                if(edit.getText().toString().length()==0){
                    str="请输入您的姓名";
                    //new AlertDialog.Builder(page_02.this).setTitle("提示框").setMessage("edit内容为空").show();
                    Toast toast=Toast.makeText(page_02.this,str,Toast.LENGTH_SHORT);
                    toast.show();return;
                }
                String str2="";
                str2+="您好，"+edit.getText()+"\n";
                RadioButton ma=(RadioButton)findViewById(R.id.male);
                RadioButton fe=(RadioButton)findViewById(R.id.female);
                if(ma.isChecked())str2+="性别：男"+"\n";
                else str2+="性别：女"+"\n";
                str2+="专业："+spinner.getSelectedItem().toString()+ "\n";
                str2+="爱好有：";
                CheckBox check01=(CheckBox)findViewById(R.id.check01);
                CheckBox check02=(CheckBox)findViewById(R.id.check02);
                CheckBox check03=(CheckBox)findViewById(R.id.check03);
                CheckBox check04=(CheckBox)findViewById(R.id.check04);
                if(check01.isChecked())str2+="音乐 ";
                if(check02.isChecked())str2+="运动 ";
                if(check03.isChecked())str2+="游泳 ";
                if(check04.isChecked())str2+="阅读 ";
                str2+="\n";
                Toast toa=Toast.makeText(page_02.this,str2,Toast.LENGTH_SHORT);
                toa.show();
                Toast toast=Toast.makeText(page_02.this,"提交成功",Toast.LENGTH_SHORT);
                toast.show();
                /*try {
                    Thread.sleep(2000);
                } catch (InterruptedException e){}*/
            }
        });
        Button cancel=(Button)findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void button_ok_click(View v){
        EditText edit=(EditText)findViewById(R.id.editText);
    }

}
