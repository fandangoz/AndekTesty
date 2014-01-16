package com.example.test;

import MyCase.Case;
import MyCase.CaseUtil;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CasesAdapter extends ArrayAdapter<Case> {
	
	public CasesAdapter(Context context, int resource, Case[] objects) {
		super(context, resource, objects);
		this.context = context;
		this.cases = objects;
		this.resource = resource;
	}
	
	@Override
	public View getView(int position, View v, ViewGroup parent) {
		
		if(v == null){
			LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.row, null);
		}
		
		Case c = cases[position];
		
		TextView valueTextView = (TextView)v.findViewById(R.id.caseName);
		valueTextView.setText(c.getValue());
		return v;
		
	}

	private final Context context;
	private final Case[] cases;
	private final int resource;
	
	

}
