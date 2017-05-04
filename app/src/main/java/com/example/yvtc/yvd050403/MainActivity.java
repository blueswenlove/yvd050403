package com.example.yvtc.yvd050403;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void click1(View v)
    {
        Intent it = new Intent(MainActivity.this, MyReceiver.class);
        it.setAction("MyClock");
        PendingIntent pi =
                PendingIntent.getBroadcast(MainActivity.this, 321, it, PendingIntent.FLAG_ONE_SHOT);

        Calendar alarm = Calendar.getInstance();
        alarm.set(Calendar.YEAR, 2017);
        alarm.set(Calendar.MONTH, Calendar.MAY);
        alarm.set(Calendar.DAY_OF_MONTH, 4);
        alarm.set(Calendar.HOUR_OF_DAY, 8);
        alarm.set(Calendar.MINUTE, 6);
        alarm.set(Calendar.SECOND, 30);

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        Log.d("REC1", "Time in Millis:" + alarm.getTimeInMillis());
        am.set(AlarmManager.RTC_WAKEUP, alarm.getTimeInMillis(), pi);
    }
}
