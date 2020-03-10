package com.example.firstnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button button_notification;

    Button button_daily_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_notification = findViewById(R.id.button_notification);

        button_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Simple Notification!";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                 builder
                         .setSmallIcon(R.drawable.ic_priority_high_black_24dp)
                         .setContentText(message)
                         .setAutoCancel(true);

                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message", message);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, builder.build());
            }
        });

        button_daily_notification = findViewById(R.id.button_notification2);

        button_daily_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();

                calendar.set(Calendar.HOUR_OF_DAY,2);
                calendar.set(Calendar.MINUTE,12);
                calendar.set(Calendar.SECOND,5);

                Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);
                intent.setAction("MY_NOTIFICATION_MESSAGE");

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
            }
        });

    }
}
