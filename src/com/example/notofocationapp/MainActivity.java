package com.example.notofocationapp;

import java.util.Date;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.telephony.gsm.SmsManager;
import android.test.suitebuilder.annotation.SmallTest;
import android.text.style.BulletSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity{

	NotificationCompat.Builder builder;
	NotificationManager manager;
	String data ;
	Handler hand;
	int time = 0;
	Runnable run;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	hand = new Handler();
    	builder = new NotificationCompat.Builder(this);
        
        manager  = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    	
        run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				builder.setContentText(String.valueOf(time)+" sec elapsed");
				
		        builder.setContentTitle("Now Time is");
		        builder.setSmallIcon(R.drawable.ic_launcher);
				manager.notify(0, builder.build());
				if (time<31){
					time = time + 10;
					hand.postDelayed(this, 10000);
				}
				else
					hand.removeCallbacks(run);
			}
		};
        
		hand.post(run);
		
    }
    
    @Override
    
    protected void onDestroy(){
    	//hand.removeCallbacks(run);
    }

}
