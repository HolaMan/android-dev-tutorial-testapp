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
				Toast.makeText( ToastActivity.this, "按鈕被按了....", Toast.LENGTH_LONG).show();
			}});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_toast, menu);
        return true;
    }

    public void showToastShort(View view) {
    	Toast.makeText(view.getContext(), "這是Toast訊息......", Toast.LENGTH_LONG).show();
    }
    
    public void showToastLong(View view) {
    	Toast.makeText(view.getContext(), "這是Toast訊息......", Toast.LENGTH_LONG).show();
    }
    
    public void showDialog(View view) {
    	final AlertDialog alertDialog = getAlertDialog("這是對話框","請選擇...");
        alertDialog.show();
    }
    
    private AlertDialog getAlertDialog(String title,String message){
    	AlertDialog.Builder builder = new AlertDialog.Builder(ToastActivity.this);                
        builder.setTitle(title); //設定Dialog的標題
        builder.setMessage(message); //設定Dialog的內容        
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { 
            public void onClick(DialogInterface dialog, int which) {
                // do something you want when user click OK
            	Toast.makeText( ToastActivity.this, "你按了OK!!!", Toast.LENGTH_LONG).show();
            }
        });        
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // do something you want when user click cancel
            	Toast.makeText( ToastActivity.this, "你按了Cancel!!!", Toast.LENGTH_LONG).show();
            }
        });
        return builder.create();
    }
    
    public void onVibrate(View view) {
    	Vibrator myVibrator = (Vibrator) getApplication().getSystemService(Service.VIBRATOR_SERVICE);
        myVibrator.vibrate(500); // 震動半秒     
    }
}
