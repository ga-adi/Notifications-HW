package com.adi.ho.jackie.notificationshw;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    Button instagramBut;
    Button screenshotBut;
    Button newMessageBut;
    Button musicPlayerBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instagramBut = (Button) findViewById(R.id.instagram_note);
        screenshotBut = (Button) findViewById(R.id.screenshot_note);
        newMessageBut = (Button) findViewById(R.id.new_messages);
        musicPlayerBut = (Button)findViewById(R.id.music_player_notif);

        final NotificationCompat.Builder noteBuilder = new NotificationCompat.Builder(MainActivity.this);
        final Intent realIntent = new Intent(MainActivity.this, BonusActivity.class);
        final PendingIntent goToActivityPendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), realIntent, 0);


        instagramBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteBuilder.setContentTitle("Instagram");
                noteBuilder.setContentText("Go behind the scenes at the Oscars");
                noteBuilder.setSmallIcon(android.R.drawable.ic_menu_camera);
                noteBuilder.setContentIntent(goToActivityPendingIntent);
                noteBuilder.setColor(Color.GRAY);
                Notification notification = noteBuilder.build();
                NotificationManager notiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notiManager.notify(1002, notification);

            }
        });

        screenshotBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.BigPictureStyle bigScreenShotStyle = new NotificationCompat.BigPictureStyle();
                bigScreenShotStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.android)).build();
                bigScreenShotStyle.setBigContentTitle("Screenshot captured.");
                noteBuilder.setSmallIcon(android.R.drawable.ic_menu_gallery);
                noteBuilder.setStyle(bigScreenShotStyle);
                noteBuilder.addAction(android.R.drawable.ic_menu_share, "SHARE", goToActivityPendingIntent);
                noteBuilder.addAction(R.drawable.ic_action_trash, "DELETE", goToActivityPendingIntent);
                Notification notification = noteBuilder.build();
                NotificationManager notiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notiManager.notify(1001, notification);
            }
        });
        newMessageBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.InboxStyle newMessageInboxStyle = new NotificationCompat.InboxStyle();
                newMessageInboxStyle.addLine("Cheeta: Bananas on sale");
                newMessageInboxStyle.addLine("George: Curious about your blog post");
                newMessageInboxStyle.addLine("Nikko: Need a rid to evolve?");
                newMessageInboxStyle.setSummaryText("+2 more");

                noteBuilder.setStyle(newMessageInboxStyle);
                noteBuilder.setColor(Color.GRAY);
                noteBuilder.setSmallIcon(android.R.drawable.ic_menu_info_details);
                noteBuilder.setContentTitle("5 new messages");
                noteBuilder.setContentIntent(goToActivityPendingIntent);

                Notification notification = noteBuilder.build();
                NotificationManager notiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notiManager.notify(1000, notification);
            }
        });

        musicPlayerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoteViews contentView = new RemoteViews(getPackageName(),R.layout.custom_notification_layout);

                contentView.setTextViewText(R.id.album_name, "Rolling In The Deep");
                contentView.setTextViewText(R.id.song_name, "Adele - Pay Close Attent...");
                contentView.setImageViewResource(R.id.pause, android.R.drawable.ic_media_pause);
                contentView.setImageViewResource(R.id.fastforward,android.R.drawable.ic_media_ff);
                contentView.setImageViewResource(R.id.exit,android.R.drawable.ic_menu_close_clear_cancel);

                noteBuilder.setContent(contentView);
                noteBuilder.setSmallIcon(android.R.drawable.ic_media_play);
                noteBuilder.setContentTitle("Rolling in the Deep");
                noteBuilder.setContentText("Adele");

                Notification notification = noteBuilder.build();
                notification.contentView = contentView;
                NotificationManager notiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notiManager.notify(1004, notification);
            }
        });


    }
}
