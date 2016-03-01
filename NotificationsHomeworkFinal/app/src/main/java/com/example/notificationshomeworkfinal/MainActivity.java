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
        mSeamlessFab = (FloatingActionButton)findViewById(R.id.seamless_fab);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBuilder.setSmallIcon(android.R.drawable.ic_menu_info_details);
                mBuilder.setContentTitle("Clear Notifacations");


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
                notificationManager.notify(1, notification);
            }
        });

        mDinnerWithMikeFab = (FloatingActionButton)findViewById(R.id.dinner_with_mike_fab);
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
                notificationManager.notify(1, notification);

            }
        });
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
