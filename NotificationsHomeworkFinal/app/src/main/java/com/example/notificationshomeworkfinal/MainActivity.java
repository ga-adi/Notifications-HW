package com.example.notificationshomeworkfinal;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder mBuilder;
    FloatingActionButton mSeamlessFab;
    FloatingActionButton mDinnerWithMikeFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBuilder = new NotificationCompat.Builder(MainActivity.this);
        mSeamlessFab = (FloatingActionButton) findViewById(R.id.seamless_fab);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBuilder.setSmallIcon(android.R.drawable.ic_menu_info_details);
                mBuilder.setContentTitle("Clear Notifications");


                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 12, notificationIntent, 0);

                mBuilder.setContentIntent(pendingIntent);
                Notification notification = mBuilder.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.cancelAll();
                notificationManager.notify(1, notification);


            }
        });

        mSeamlessFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBuilder.setSmallIcon(R.drawable.ic_account_circle_green_24dp);
                mBuilder.setContentTitle("94833");
                mBuilder.setContentText("Breaking News: Your Seamless order is being prepared. Our crystal estimates your delivery time between 1:30PM and 1:40PM");
                Intent notificationIntent = new Intent(MainActivity.this, SecondActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 12, notificationIntent, 0);
                mBuilder.addAction(R.drawable.ic_reply_black_24dp, "REPLY", pendingIntent);

                mBuilder.setContentIntent(pendingIntent);
                Notification notification = mBuilder.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(2, notification);
            }
        });

        mDinnerWithMikeFab = (FloatingActionButton) findViewById(R.id.dinner_with_mike_fab);
        mDinnerWithMikeFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBuilder.setSmallIcon(R.drawable.ic_account_circle_green_24dp);
                mBuilder.setContentTitle("Michael");
                mBuilder.setSubText("Dinner Tonight?");
                mBuilder.setContentText("Let's grab some dinner are you free?");
                Intent notificationIntent = new Intent(MainActivity.this, SecondActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 12, notificationIntent, 0);
                mBuilder.addAction(R.drawable.ic_archive_grey_24dp, "ARCHIVE", pendingIntent);
                mBuilder.addAction(R.drawable.ic_reply_black_24dp, "REPLY", pendingIntent);

                mBuilder.setContentIntent(pendingIntent);
                Notification notification = mBuilder.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(3, notification);

            }
        });

        FloatingActionButton fab0 = (FloatingActionButton) findViewById(R.id.fab0);
        fab0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);

                builder.setSmallIcon(android.R.drawable.ic_lock_idle_lock);
                builder.setContentTitle("This is a test title");
                builder.setContentText("This is some text used for the content of this notification");

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);

                builder.setContentIntent(pendingIntent);

                Notification notification = builder.build();

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(4, notification);

            }
        });

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);

                builder.setSmallIcon(android.R.drawable.ic_menu_gallery);
                builder.setContentTitle("Instagram");
                builder.setContentText("Go behind the scenes at The Oscars");

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);

                builder.setContentIntent(pendingIntent);

                Notification notification = builder.build();

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(5, notification);

            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);

                builder.setSmallIcon(android.R.drawable.ic_menu_compass);
                builder.setContentTitle("USB debugging connected");
                builder.setContentText("Touch to disable USB debugging.");

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);

                builder.setContentIntent(pendingIntent);

                Notification notification = builder.build();

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(6, notification);

            }
        });
    }

}
