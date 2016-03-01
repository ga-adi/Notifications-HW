package com.charlesdrews.notificationshw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String MESSAGE_KEY = "messageKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.test_title_button).setOnClickListener(this);
        findViewById(R.id.debug_conntect_button).setOnClickListener(this);
        findViewById(R.id.seamless_button).setOnClickListener(this);
        findViewById(R.id.greg_miller_button).setOnClickListener(this);
        findViewById(R.id.clear_notifications_button).setOnClickListener(this);
        findViewById(R.id.michael_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_title_button:
                KyleNotifications.testTitle(this);
                break;
            case R.id.debug_conntect_button:
                KyleNotifications.debugConnected(this);
                break;
            case R.id.seamless_button:
                KyleNotifications.seamless(this);
                break;
            case R.id.greg_miller_button:
                CharlieNotifications.gregMillerNotification(this);
                break;
            case R.id.clear_notifications_button:
                CharlieNotifications.clearNotification(this);
                break;
            case R.id.michael_button:
                CharlieNotifications.michaelEmailNotification(this);
                break;
        }
    }
}
