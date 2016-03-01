package com.example.wasabi.notificationhw;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;

public class ClaireActivity extends AppCompatActivity {

    public static int INBOX_NOTIFICATION_ID = 100;
    public static int BIGTEXT_NOTIFICATION_ID = 200;
    public static int ACTION_NOTIFICATION_ID = 300;
    public static int BONUS_NOTIFICATION_ID = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claire);

        Button inboxButton = (Button)findViewById(R.id.inbox_button);
        Button bigTextButton = (Button)findViewById(R.id.bigtext_button);
        Button actionButton = (Button)findViewById(R.id.action_button);
        Button bonusButton = (Button)findViewById(R.id.bonus_button);
        Button nextButton = (Button)findViewById(R.id.next_button);

        inboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ClaireActivity.this);
                builder.setStyle(new NotificationCompat.InboxStyle().setBigContentTitle("5 new messages")
                        .addLine("Cheeta: Bananas on sale")
                        .addLine("George: Curious about your blog post")
                        .addLine("Nikko: Need a ride to Evolve?")
                        .setSummaryText("+2 more"));
                builder.setSmallIcon(android.R.drawable.ic_dialog_info);
                builder.setContentTitle("5 new messages");
                builder.setContentText("Scroll down to read");
                Intent intent = new Intent(ClaireActivity.this,ClaireActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(ClaireActivity.this, (int)System.currentTimeMillis(), intent, 0);
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);

                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(INBOX_NOTIFICATION_ID,builder.build());
            }
        });

        bigTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ClaireActivity.this);
                builder.setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle("94833")
                        .bigText("Breaking News: Your Seamless order is being prepared. Our crystal ball estimates your delivery time between 1:30 PM and 1:40 PM."));
                builder.setSmallIcon(android.R.drawable.ic_menu_camera);
                builder.setContentTitle("94833");
                builder.setContentText("New story is delivered.");
                Intent intent = new Intent(ClaireActivity.this,ClaireActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(ClaireActivity.this, (int)System.currentTimeMillis(), intent, 0);
                builder.addAction(android.R.drawable.ic_menu_send, "REPLY", pIntent);
                builder.setAutoCancel(true);

                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(INBOX_NOTIFICATION_ID,builder.build());
            }
        });

        bigTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ClaireActivity.this);
                builder.setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle("94833")
                        .bigText("Breaking News: Your Seamless order is being prepared. Our crystal ball estimates your delivery time between 1:30 PM and 1:40 PM."));
                builder.setSmallIcon(android.R.drawable.ic_menu_camera);
                builder.setContentTitle("94833");
                builder.setContentText("New story is delivered.");
                Intent intent = new Intent(ClaireActivity.this,ClaireActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(ClaireActivity.this, (int)System.currentTimeMillis(), intent, 0);
                builder.addAction(android.R.drawable.ic_menu_send,"REPLY",pIntent);
                builder.setAutoCancel(true);

                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(BIGTEXT_NOTIFICATION_ID,builder.build());
            }
        });

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ClaireActivity.this);

                Spannable sb = new SpannableString("Dinner tonight?");
                sb.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, sb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                builder.setSmallIcon(android.R.drawable.ic_menu_call);
                builder.setContentTitle("Michael");
                builder.setContentText("Message from Michael");
                builder.setStyle(new NotificationCompat.InboxStyle().setBigContentTitle("Michael")
                        .addLine(sb)
                        .addLine("Let's grab some dinner. Are your free?")
                        .setSummaryText("alex.faa.borg@android.com"));

                Intent intent = new Intent(ClaireActivity.this,ClaireActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(ClaireActivity.this, (int)System.currentTimeMillis(), intent, 0);
                builder.addAction(android.R.drawable.ic_menu_upload,"ARCHIVE",pIntent);
                builder.addAction(android.R.drawable.ic_menu_send,"REPLY",pIntent);
                builder.setAutoCancel(true);

                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(ACTION_NOTIFICATION_ID,builder.build());
            }
        });

        bonusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ClaireActivity.this);

                Spannable sb = new SpannableString("Dinner tonight?");
                sb.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, sb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                RemoteViews contentView =  new RemoteViews(getPackageName(), R.layout.custom_notification);
                contentView.setImageViewResource(R.id.album_art, R.drawable.profile);
                contentView.setTextViewText(R.id.title_tv, "Midnight City");
                contentView.setTextViewText(R.id.artist_tv, "M83 - Hurry Up, We're Dreaming");


                builder.setSmallIcon(android.R.drawable.ic_media_play);
                builder.setContentTitle("Midnight City");
                builder.setContentText("M83");

                builder.addAction(android.R.drawable.ic_media_pause, null, null);
                builder.addAction(android.R.drawable.ic_media_play,null,null);
                builder.addAction(android.R.drawable.ic_menu_close_clear_cancel,null,null);
                builder.setContent(contentView);

                Intent intent = new Intent(ClaireActivity.this,ClaireActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(ClaireActivity.this, (int)System.currentTimeMillis(), intent, 0);
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);

                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(ACTION_NOTIFICATION_ID,builder.build());
            }
        });
    }
}
