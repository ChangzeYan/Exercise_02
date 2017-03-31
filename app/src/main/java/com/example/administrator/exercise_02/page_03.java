package com.example.administrator.exercise_02;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/3/9.
 */

public class page_03 extends AppCompatActivity {

    private TextView txt;
    private ListView listview;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeActionOverflowMenuShown();
        setContentView(R.layout.page_03);
        listview =(ListView)findViewById(R.id.listview);
        final String [] data={"移动计算","计算机组成原理","数据结构","操作系统","面向对象技术","逻辑设计"};
        ArrayAdapter<String >adapter=new ArrayAdapter<String>(page_03.this,android.R.layout.simple_spinner_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str="";
                str=data[position];
                txt=(TextView)findViewById(R.id.textview);
                txt.setText("选择的科目是："+str);
            }
        });
        txt=(TextView)findViewById(R.id.textview);
        registerForContextMenu(txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(!"退出".equals(item.getTitle().toString())) txt.setText("你选择了选项菜单："+item.getTitle());
        else this.finish();
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("快捷菜单标题：");
        menu.add("复制");
        menu.add("粘贴");
        menu.add("撤销");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        txt.setText("您选择了快捷菜单："+item.getTitle());
        return true;
    }

    private void showToast(String str){
        Toast.makeText(page_03.this,str,Toast.LENGTH_SHORT);
    }

    public void aboutAleart(String msg){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(msg).setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
            }
        });
        AlertDialog alert= builder.create();
        alert.show();
    }
    private void exitAleart(String msg){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(msg).setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }
    private void makeActionOverflowMenuShown(){
        try{
            ViewConfiguration config= ViewConfiguration.get(this);
            Field menuKeyField= ViewConfiguration.class.getDeclaredField("as");
            if(menuKeyField!=null){
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config,false);
            }
        } catch (Exception e) {

        }
    }
}
