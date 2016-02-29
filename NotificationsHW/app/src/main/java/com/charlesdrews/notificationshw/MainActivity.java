package com.charlesdrews.notificationshw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.greg_miller_button).setOnClickListener(this);

        CharlieNotifications.michaelEmailNotification(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.greg_miller_button:
                CharlieNotifications.gregMillerNotification(this);
                break;
        }
    }
}
