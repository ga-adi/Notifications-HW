package com.example.wasabi.notificationhw;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WillActivity extends AppCompatActivity {

    Button mClearButton;
    Button mScreenshotButton;
    Button mChatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_will);

        //CLEAR NOTIFICATIONS
        mClearButton = (Button)findViewById(R.id.buttonClearNotifications);
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builderClear = new NotificationCompat.Builder(WillActivity.this);
                builderClear.setSmallIcon(android.R.drawable.ic_menu_info_details);
                builderClear.setContentTitle("Clear Notifications");
                builderClear.setContentText("");

                Intent intent = new Intent(WillActivity.this, WillActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(WillActivity.this, (int)System.currentTimeMillis(),intent,0);
                builderClear.setContentIntent(pendingIntent);

                Notification notification = builderClear.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, notification);

            }
        });

        //SCREENSHOT NOTIFICATION


        mScreenshotButton = (Button)findViewById(R.id.screenshotButton);
        mScreenshotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builderScreenshot = new NotificationCompat.Builder(WillActivity.this);
                builderScreenshot.setSmallIcon(android.R.drawable.ic_menu_gallery);
                builderScreenshot.setContentTitle("Screenshot captured.");
                builderScreenshot.setContentText("");

                NotificationCompat.BigPictureStyle picHere = new NotificationCompat.BigPictureStyle();
                picHere.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.pic)).build();
                builderScreenshot.setStyle(picHere);

                builderScreenshot.addAction(android.R.drawable.ic_menu_share, "Share", null);
                builderScreenshot.addAction(android.R.drawable.ic_menu_delete, "Delete", null);
                Notification notification2 = builderScreenshot.build();
                NotificationManager notificationManager2 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager2.notify(2,notification2);

            }
        });

        //CHAT NOTIFICATION

        mChatButton = (Button)findViewById(R.id.chatButton);
        mChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builderScreenshot = new NotificationCompat.Builder(WillActivity.this);

                builderScreenshot.setSmallIcon(android.R.drawable.picture_frame);
                builderScreenshot.setContentTitle("Greg Miller");
                builderScreenshot.setContentText("Message delivered");

                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.setBigContentTitle("Greg Miller");
                bigTextStyle.bigText("Liked: Tim: \"It's cool that the @BatmanvSuperman movie cast the guy from Gigli.\n@GameOverGreggy.\"..Are you srsly making a joke right now, Tim?");
                builderScreenshot.setStyle(bigTextStyle);

                Notification notification = builderScreenshot.build();
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(3,notification);

            }
        });



    }


}
