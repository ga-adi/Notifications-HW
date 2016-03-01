package com.example.mikegregnotificationhw;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mButton5;
    Button mButton6;
    Button mBonus;

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
        mBonus = (Button) findViewById(R.id.buttonBONUS);

        mButton1.setText("Test Notification");
        mButton2.setText("Debugging");
        mButton3.setText("");
        mButton4.setText("BatmanvSuperman");
        mButton5.setText("Clear Notifications");
        mButton6.setText("5 Notifications");
        mBonus.setText("Bonus");

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
                builder2.setSmallIcon(android.R.drawable.ic_secure)
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

            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder4 = new NotificationCompat.Builder(MainActivity.this);
                builder4.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.gregmiller));

                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                bigText.bigText("Liked: Tim: It's cool that the @BatmanvSuperman movie cast the guy from Gigli.\n@GameOverGreggy: Are you srsly making a joke right now, Tim?");
                builder4.setStyle(bigText);

                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), notificationIntent, 0);
                builder4.setContentIntent(pendingIntent).setAutoCancel(true);
                Notification notification = builder4.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(4, notification);
            }
        });

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder5 = new NotificationCompat.Builder(MainActivity.this);
                builder5.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.clearnotifications))
                        .setContentTitle("Clear Notifications");
                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), notificationIntent, 0);
                builder5.setContentIntent(pendingIntent)
                        .setAutoCancel(true);
                Notification notification = builder5.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(5, notification);
            }
        });

        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder6 = new NotificationCompat.Builder(MainActivity.this);
                builder6.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.largealert));

                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                inboxStyle.setBigContentTitle("5 new messages");
                inboxStyle.addLine("Cheeta: Bananas on sale");
                inboxStyle.addLine("George: Curious about your blogpost.");
                inboxStyle.addLine("Nikko: Need a ride to Evolve?");
                inboxStyle.setSummaryText("+2 more");
                builder6.setStyle(inboxStyle);

                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), notificationIntent, 0);
                builder6.setContentIntent(pendingIntent).setAutoCancel(true);
                Notification notification = builder6.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(6, notification);
            }
        });

        mBonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification.Builder builder7 = new Notification.Builder(MainActivity.this);
                builder7.setAutoCancel(true);
                Notification notification = builder7.build();
                NotificationManager mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                RemoteViews contentView = new RemoteViews(getPackageName(), R.xml.customnotificationlayout);
                contentView.setImageViewResource(R.id.image, R.drawable.bonus);
                contentView.setTextViewText(R.id.title, "Rolling in the deep");
                contentView.setTextViewText(R.id.text, "Adele - Pay Close...");
                contentView.setImageViewResource(R.id.pause, android.R.drawable.ic_media_pause);
                contentView.setImageViewResource(R.id.skip, android.R.drawable.ic_media_next);
                notification.contentView = contentView;

                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), notificationIntent, 0);
                notification.contentIntent = contentIntent;
                mNotificationManager.notify(7, notification);
            }
        });
    }
}
