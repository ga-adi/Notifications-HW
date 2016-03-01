package com.roberterrera.notifications_hw;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mInstagram;
    Button mScreenshot;
    Button m5messages;
    Button mClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInstagram=(Button)findViewById(R.id.instagram);
        mScreenshot=(Button)findViewById(R.id.screenshot);
        m5messages=(Button)findViewById(R.id.new_messages_5);
        mClear=(Button)findViewById(R.id.clear_notifications);


        mInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder= new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(R.drawable.ig);
                builder.setContentTitle("Instagram");
                builder.setContentText("Go Behind the scenes at the Oscars");
                Intent intent= new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent= PendingIntent.getActivity(MainActivity.this,(int) System.currentTimeMillis(),intent,0);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

                Notification notification= builder.build();
                NotificationManager manager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                manager.notify(1, notification);


            }
        });

        mScreenshot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder= new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(android.R.drawable.picture_frame);

                Intent intent= new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent= PendingIntent.getActivity(MainActivity.this,(int) System.currentTimeMillis(),intent,0);

                NotificationCompat.BigPictureStyle bigPictureStyle= new NotificationCompat.BigPictureStyle();
                bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.adi_group_photo_2)).build();
                bigPictureStyle.setBigContentTitle("Screenshot Captured");
                builder.addAction(android.R.drawable.ic_menu_share, "Share", pendingIntent);
                builder.addAction(android.R.drawable.ic_delete,"Delete",pendingIntent);

                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

                Notification notification= builder.build();
                NotificationManager manager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                manager.notify(2, notification);

            }
        });

        m5messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder= new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(android.R.drawable.ic_menu_info_details);

                Intent intent= new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent= PendingIntent.getActivity(MainActivity.this,(int) System.currentTimeMillis(),intent,0);

                NotificationCompat.InboxStyle inboxStyle= new NotificationCompat.InboxStyle();
                inboxStyle.addLine("Cheetah:Bannanas on Sale");
                inboxStyle.addLine("George: Curious about your blog post");
                inboxStyle.addLine("Nikko: Need a ride to evolve?");
                inboxStyle.setSummaryText("+2 more");



            }
        });


    }
}
