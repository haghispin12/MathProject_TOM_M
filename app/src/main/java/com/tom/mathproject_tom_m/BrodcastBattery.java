package com.tom.mathproject_tom_m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

class BrodcastBattery extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int battery=intent.getIntExtra("level",0);
        Toast.makeText(context, battery+"%", Toast.LENGTH_SHORT).show();
    }
}
