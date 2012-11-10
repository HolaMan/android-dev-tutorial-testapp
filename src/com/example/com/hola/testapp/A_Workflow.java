package com.example.com.hola.testapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class A_Workflow extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__workflow);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_a__workflow, menu);
        return true;
    }
    
    public void gotoB_Activity(View view) {
    	finish();
    	Intent intent = new Intent( A_Workflow.this, B_Workflow.class);
    	this.startActivity(intent);
    }
}
