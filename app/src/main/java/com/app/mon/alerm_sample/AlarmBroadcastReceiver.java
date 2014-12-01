package com.app.mon.alerm_sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by FukuoKadota on 2014/11/28.
 */
public class AlarmBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "アラームが呼ばれたよ！" + intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();
    }
}
