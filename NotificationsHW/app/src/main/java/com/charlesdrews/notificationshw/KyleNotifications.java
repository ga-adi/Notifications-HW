package com.charlesdrews.notificationshw;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Kyle McNee on 2/29/2016.
 */
public class KyleNotifications extends AppCompatActivity{
    public static void testTitle(Context context){
        NotificationCompat.Builder testBuilder = new NotificationCompat.Builder(context);
        testBuilder.setSmallIcon(R.drawable.ic_lock_black_18dp);
        testBuilder.setContentTitle("This is a test title");
        testBuilder.setContentText("This is some text used for the content of this notification.");

        Notification notification = testBuilder.build();
        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, notification);
    }

    public static void debugConnected(Context context){
        NotificationCompat.Builder debugBuilder = new NotificationCompat.Builder(context);
        debugBuilder.setSmallIcon(R.drawable.ic_android_black_18dp);
        debugBuilder.setContentTitle("USB debugging connected");
        debugBuilder.setContentText("Touch to disable USB debugging");

        Notification notification = debugBuilder.build();
        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(2, notification);
    }

    public static void seamless(Context context){
        NotificationCompat.Builder seamlessBuilder = new NotificationCompat.Builder(context);

        String message = "Calm down, you'll get your food soon.";
        Intent intent = new Intent(context, ActionActivity.class);
        intent.putExtra("seamless", message);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);

        seamlessBuilder.addAction(R.drawable.ic_reply_black_18dp, "REPLY", pendingIntent);

        seamlessBuilder.setSmallIcon(R.drawable.ic_assignment_ind_black_18dp);
        seamlessBuilder.setContentTitle("94833");
        seamlessBuilder.setContentText("Breaking News: Your Seamless order is being prepared. Our crystal ball estimates your delivery time between 4:10 PM and 4:20 PM");

        Notification notification = seamlessBuilder.build();
        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(3, notification);

    }
}
