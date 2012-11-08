package com.example.com.hola.testapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.app.Activity;
import android.view.Menu;

public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
                
        // go to the select card activity after splash
        Handler handler = new Handler();        
        handler.postDelayed(new Runnable() { 
            @Override
            public void run() { 
                // make sure we close the splash screen so the user won't come back when it presses back key 
                finish();
            } 
        }, 3000); // time in milliseconds (1 second = 1000 milliseconds)
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_splash, menu);
        return true;
    }

    
}
