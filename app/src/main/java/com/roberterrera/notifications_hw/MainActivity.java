package com.roberterrera.notifications_hw;

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
    Button mTestTitle;
    Button mUSBDebugging;
    Button mTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestTitle = (Button) findViewById(R.id.button_testtitle);
        mUSBDebugging = (Button) findViewById(R.id.button_usbdebugging);
        mTwitter = (Button) findViewById(R.id.button_twitter);

        mTestTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(android.R.drawable.ic_lock_idle_lock);
                builder.setContentTitle("This is a test title");
                builder.setContentText("This is some text used for the content of this notification.");

                Intent intent= new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent= PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);
                builder.setContentIntent(pendingIntent);

                builder.setAutoCancel(true);

                Notification notification= builder.build();
                NotificationManager manager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                manager.notify(15, notification);

            }
        });

        mUSBDebugging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(android.R.drawable.ic_menu_info_details);
                builder.setContentTitle("USB debugging connected");
                builder.setContentText("Touch to disable USB debugging.");

                Intent intent= new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent= PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);
                builder.setContentIntent(pendingIntent);

                builder.setAutoCancel(true);

                Notification notification= builder.build();
                NotificationManager manager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                manager.notify(45, notification);

            }
        });

        mTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(R.drawable.twitterlogo);
                builder.setContentTitle("Greg Miller");
                builder.setContentText(getString(R.string.tweet_text));

                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.setBigContentTitle("Greg Miller");
                bigTextStyle.bigText(getString(R.string.tweet_text));
                builder.setStyle(bigTextStyle);

                Intent intent= new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);
                builder.setContentIntent(pendingIntent);

                Notification notification = builder.build();
                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                builder.setPriority(Notification.PRIORITY_MAX);
                manager.notify(24,notification);

            }
        });

    }
}
