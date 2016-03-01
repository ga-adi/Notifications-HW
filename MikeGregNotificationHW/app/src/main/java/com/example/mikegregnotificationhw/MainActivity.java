package com.example.mikegregnotificationhw;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mButton5;
    Button mButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton5 = (Button) findViewById(R.id.button5);
        mButton6 = (Button) findViewById(R.id.button6);

        mButton1.setText("Test Notification");
        mButton2.setText("Debugging");
        mButton3.setText("Seamless");
        mButton4.setText("");
        mButton5.setText("");
        mButton6.setText("");

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder1 = new NotificationCompat.Builder(MainActivity.this);
                builder1.setSmallIcon(android.R.drawable.ic_lock_lock)
                        .setContentTitle("This is a test Title")
                        .setContentText("This is some text used for the content of this notification.");
                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), notificationIntent, 0);
                builder1.setContentIntent(pendingIntent)
                        .setAutoCancel(true);
                Notification notification = builder1.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, notification);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder2 = new NotificationCompat.Builder(MainActivity.this);
                builder2.setSmallIcon(android.R.drawable.ic_media_play)
                        .setContentTitle("USB debugging connected")
                        .setContentText("Touch to disable USB debugging.");
                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), notificationIntent, 0);
                builder2.setContentIntent(pendingIntent)
                        .setAutoCancel(true);
                Notification notification = builder2.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(2, notification);
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.setBigContentTitle("94833")
                        .bigText("Breaking News: Your Seamless order is being prepared. Our crystal ball estimates your delivery time between 1:30PM and 1:40PM.");

                NotificationCompat.Builder builder3 = new NotificationCompat.Builder(MainActivity.this);
                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), notificationIntent, 0);
                builder3.setSmallIcon(android.R.drawable.ic_menu_gallery)
                        .addAction(android.R.drawable.ic_menu_add,"REPLY",pendingIntent)
                        .setStyle(bigTextStyle);
                builder3.setContentIntent(pendingIntent)
                        .setAutoCancel(true);
                Notification notification = builder3.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(3, notification);
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
