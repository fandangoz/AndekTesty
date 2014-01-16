package com.example.test;

import java.util.List;

import MyCase.Case;
import MyCase.CaseUtil;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {       	
			CaseUtil.initialise(getApplicationContext().getResources().getXml(R.xml.cases));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        ListView menuList = (ListView) findViewById(R.id.menuList);
        List<Case> casesList = CaseUtil.getCaseList();
        Case[] cases = (Case[]) casesList.toArray(new Case[casesList.size()]);
       menuList.setAdapter(new CasesAdapter(getApplicationContext(), R.layout.row, cases));
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
