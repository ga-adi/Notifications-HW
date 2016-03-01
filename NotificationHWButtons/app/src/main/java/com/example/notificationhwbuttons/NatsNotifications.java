package com.example.notificationhwbuttons;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by nat on 2/29/16.
 */
public class NatsNotifications {

    public static final int TEST_TITLE=10;
    public static final int DEBUG_USB=9;
    public static final int GREG=8;
    private Activity mActivity=null;
    public NatsNotifications(Activity a){
        mActivity=a;
    }
    public void createNotificationTestTitle(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mActivity);
        builder.setSmallIcon(android.R.drawable.ic_lock_idle_lock);
        builder.setContentTitle("This is a test title");
        builder.setContentText("This is some test used for the content of notification");

        Intent notificationIntent = new Intent(mActivity,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mActivity,(int)System.currentTimeMillis(),notificationIntent,0);

        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager)mActivity.getSystemService(mActivity.NOTIFICATION_SERVICE);
        notificationManager.notify(TEST_TITLE,notification);
    }
    public void createNotificationUSBDebggingConnected(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mActivity);
        builder.setSmallIcon(R.drawable.usdebug_b);
        builder.setContentTitle("USB DEBUGGING CONNECTED");
        builder.setContentText("Touch to Disable USB Debugging");

        Intent notificationIntent = new Intent(mActivity,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mActivity,(int)System.currentTimeMillis(),notificationIntent,0);

        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager)mActivity.getSystemService(mActivity.NOTIFICATION_SERVICE);
        notificationManager.notify(DEBUG_USB,notification);
    }

    public void createNotificationUSBGregMiller(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mActivity);

        builder.setSmallIcon( R.drawable.gregmiller_b);
       // builder.setContentTitle("Greg Miller");
        //builder.setContentText("Like");

        Intent notificationIntent = new Intent(mActivity,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mActivity,(int)System.currentTimeMillis(),notificationIntent,0);

        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.setBigContentTitle("Greg Miller");
        bigText.bigText("Liked: “It’s cool that the @BatmanvSuperman movie cast the guy from Gigli.” @GameOverGreggy:”..Are you srsly making a joke right now, Tim?”");
        //bigText.setSummaryText("Reply");
        builder.setStyle(bigText);
        builder.addAction(android.R.drawable.ic_media_rew,"reply",pendingIntent);
        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager)mActivity.getSystemService(mActivity.NOTIFICATION_SERVICE);
        notificationManager.notify(GREG,notification);
    }
}
