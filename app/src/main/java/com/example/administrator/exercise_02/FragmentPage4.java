package com.example.administrator.exercise_02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentPage4 extends Fragment{

	private Button frag04_btn_ok;
	private Button frag04_btn_cancel;
	private Context context;
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context=getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_4,container,false);
		frag04_btn_ok=(Button)view.findViewById(R.id.frag04_btn_ok);
		frag04_btn_ok.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context,"提交成功",Toast.LENGTH_SHORT).show();
			}
		});
		frag04_btn_cancel=(Button) view.findViewById(R.id.frag04_btn_cancel);
		frag04_btn_cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context,MainActivity.class));
			}
		});
		return view;
	}	
}