package com.example.com.hola.testapp;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        
        Button button4 = (Button)this.findViewById(R.id.button4);
        button4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText( ToastActivity.this, "���s�Q���F....", Toast.LENGTH_LONG).show();
			}});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_toast, menu);
        return true;
    }

    public void showToastShort(View view) {
    	Toast.makeText(view.getContext(), "�o�OToast�T��......", Toast.LENGTH_LONG).show();
    }
    
    public void showToastLong(View view) {
    	Toast.makeText(view.getContext(), "�o�OToast�T��......", Toast.LENGTH_LONG).show();
    }
    
    public void showDialog(View view) {
    	final AlertDialog alertDialog = getAlertDialog("�o�O��ܮ�","�п��...");
        alertDialog.show();
    }
    
    private AlertDialog getAlertDialog(String title,String message){
    	AlertDialog.Builder builder = new AlertDialog.Builder(ToastActivity.this);                
        builder.setTitle(title); //�]�wDialog�����D
        builder.setMessage(message); //�]�wDialog�����e        
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { 
            public void onClick(DialogInterface dialog, int which) {
                // do something you want when user click OK
            	Toast.makeText( ToastActivity.this, "�A���FOK!!!", Toast.LENGTH_LONG).show();
            }
        });        
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // do something you want when user click cancel
            	Toast.makeText( ToastActivity.this, "�A���FCancel!!!", Toast.LENGTH_LONG).show();
            }
        });
        return builder.create();
    }
    
    public void onVibrate(View view) {
    	Vibrator myVibrator = (Vibrator) getApplication().getSystemService(Service.VIBRATOR_SERVICE);
        myVibrator.vibrate(500); // �_�ʥb��     
    }
}
