package com.app.mon.alerm_sample;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setAlarm(View v){
        Toast.makeText(this, "アラームボタンを押したよ！", Toast.LENGTH_SHORT).show();

        AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
        intent.putExtra("data", "1");

        PendingIntent operation = PendingIntent.getBroadcast(this, 1000, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, operation);

        intent = new Intent(this, AlarmBroadcastReceiver.class);
        intent.putExtra("data", "2");
        operation = PendingIntent.getBroadcast(this, 1001, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 100000, operation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
