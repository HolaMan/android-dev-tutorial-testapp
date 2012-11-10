package com.example.com.hola.testapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class B_Workflow extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b__workflow);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_b__workflow, menu);
        return true;
    }
    public void gotoC_Activity(View view) {
    	Intent intent = new Intent( B_Workflow.this, C_Workflow.class);
    	this.startActivity(intent);
    }
}
