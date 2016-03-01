package com.adi.ho.jackie.notificationshw;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button davidButton1 = (Button) findViewById(R.id.david_notif_button1);
        Button davidButton2 = (Button) findViewById(R.id.david_notif_button2);
        Button davidButton3 = (Button) findViewById(R.id.david_notif_button3);

        davidButton1.setOnClickListener(this);
        davidButton2.setOnClickListener(this);
        davidButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(MainActivity.NOTIFICATION_SERVICE);
        switch(v.getId()) {
            case R.id.david_notif_button1:
                NotificationCompat.BigTextStyle style1 = new NotificationCompat.BigTextStyle();
                style1.setBigContentTitle("This is a test title");
                style1.bigText("This is some text used for the content of this notification");

                NotificationCompat.Builder builder1 = new NotificationCompat.Builder(MainActivity.this);
                builder1.setStyle(style1);
                builder1.setSmallIcon(android.R.drawable.ic_lock_idle_lock);

                Notification notification = builder1.build();
                notificationManager.notify(1, notification);

                break;
            case R.id.david_notif_button2:
                NotificationCompat.Builder builder2 = new NotificationCompat.Builder(MainActivity.this);
                builder2.setContentTitle("Clear Notifications");
                builder2.setSmallIcon(R.drawable.notification);

                Notification notification2 = builder2.build();
                notificationManager.notify(2, notification2);

                break;

            case R.id.david_notif_button3:
                NotificationCompat.Builder builder3 = new NotificationCompat.Builder(MainActivity.this);
                builder3.setContentTitle("USB debugging connected");
                builder3.setContentText("Touch to disable USB debugging.");
                builder3.setSmallIcon(R.drawable.debugging);

                Notification notification3 = builder3.build();
                notificationManager.notify(3, notification3);

                break;
        }
    }
}
