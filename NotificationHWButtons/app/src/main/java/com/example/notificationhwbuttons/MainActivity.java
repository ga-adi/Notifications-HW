package com.example.notificationhwbuttons;

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

        mButton1 = (Button)findViewById(R.id.willbutton1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(android.R.drawable.ic_menu_camera);
                builder.setContentTitle("Instagram");
                builder.setContentText("Go behind the scenes at the Oscars");

                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), notificationIntent, 0);

                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, notification);
            }
        });



        mButton2 = (Button)findViewById(R.id.willButton2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(android.R.drawable.ic_dialog_info);
                //builder.setContentTitle("5 New Messages:");
                //builder.setContentText("Go behind the scenes at the Oscars");

                NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
                style.setBigContentTitle("5 New Messages");
                style.addLine("Cheeta: Bananas on Sale");
                style.addLine("George: Curious about your blog post");
                style.addLine("Nikko: Need a ride to Evolve?");
                style.setSummaryText("+2 more");

                builder.setStyle(style);

                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 12, notificationIntent, 0);

                builder.setContentIntent(pendingIntent);

                builder.setAutoCancel(true);

                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(2, notification);
            }
        });



        mButton3 = (Button)findViewById(R.id.willButton3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(android.R.drawable.ic_menu_call);

                NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
                style.setBigContentTitle("94833");
                style.bigText("Breaking News: Your Seamless order is being prepared. Our crystal ball estimates your delivery time between 1:30 PM and 1:40 PM");




                builder.setStyle(style);

                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 12, notificationIntent, 0);

                builder.addAction(android.R.drawable.ic_media_rew, "REPLY", pendingIntent);

                builder.setContentIntent(pendingIntent);

                builder.setAutoCancel(true);

                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(3, notification);
            }
        });

        Button natButton1 = (Button)findViewById(R.id.natButton4);
        natButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NatsNotifications nn = new NatsNotifications(MainActivity.this);
                nn.createNotificationTestTitle();
            }
        });

        Button natButton2 = (Button)findViewById(R.id.natButton5);
        natButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NatsNotifications nn = new NatsNotifications(MainActivity.this);
                nn.createNotificationUSBGregMiller();
            }
        });

        Button natButton3 = (Button)findViewById(R.id.natButton6);
        natButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NatsNotifications nn = new NatsNotifications(MainActivity.this);
                nn.createNotificationUSBDebggingConnected();
            }
        });
    }
}
