package com.example.jafoole.notificationshw;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabTextMessage;
    FloatingActionButton fabInboxStyle;
    FloatingActionButton fabScreenShot;
    FloatingActionButton fabTestTitle;
    FloatingActionButton fabInstagram;
    FloatingActionButton fabUSBDebugging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO: TOP THREE FOR SIMON

        FloatingActionButton fabTextMessage = (FloatingActionButton) findViewById(R.id.fabTextMessage);
        fabTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fabInboxStyle = (FloatingActionButton) findViewById(R.id.fabInboxStyle);
        fabInboxStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fabScreenShot = (FloatingActionButton) findViewById(R.id.fabScreenShot);
        fabScreenShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //TODO: END TOP THREE


        ///
        ///
        ///


        //TODO: BOTTOM THREE FOR CHRIS


        FloatingActionButton fabTestTitle = (FloatingActionButton) findViewById(R.id.fabTestTitle);
        fabTestTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(android.R.drawable.ic_lock_idle_lock);
                builder.setContentTitle("This is a title test");
                builder.setContentText("This is some text used for the content of this notification");

                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(4, notification);

            }
        });

        FloatingActionButton fabInstagram = (FloatingActionButton) findViewById(R.id.fabInstagram);
        fabInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(android.R.drawable.ic_menu_gallery);
                builder.setContentTitle("Instagram");
                builder.setContentText("Go behind the scenes at The Oscars");

                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(5, notification);

            }
        });


        FloatingActionButton fabUSBDebugging = (FloatingActionButton) findViewById(R.id.fabUSBDebugging);
        fabUSBDebugging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(android.R.drawable.ic_menu_compass);
                builder.setContentTitle("USB debugging connected");
                builder.setContentText("Touch to disable USB debugging");



                Intent notificationIntent = new Intent(MainActivity.this, USBActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), notificationIntent, 0);

                builder.setContentIntent(pendingIntent);

                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(5, notification);
            }
        });

        //TODO: END BUTTON THREE

    }

}
