package com.example.administrator.exercise_02;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class FragmentPage5 extends Fragment{
	private Button frag05_btn_ok;
	private EditText frag05_ed;
	private EditText frag05_pwd;
	private Button frag05_btn_next;
	private Context context;
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context=getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_5,container,false);
		frag05_btn_ok=(Button)view.findViewById(R.id.frag05_btn_ok);
		frag05_ed=(EditText)view.findViewById(R.id.frag05_ed);
		frag05_pwd=(EditText)view.findViewById(R.id.frag05_pwd);
		frag05_btn_ok.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				frag05_ed.setText("");
				frag05_pwd.setText("");
			}
		});
		frag05_btn_next=(Button)view.findViewById(R.id.frag05_btn_next);
		frag05_btn_next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context,"提交成功",Toast.LENGTH_SHORT).show();
			}
		});
		//return inflater.inflate(R.layout.fragment_5, null);
		return view;
	}
}