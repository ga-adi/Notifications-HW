package com.charlesdrews.notificationshw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActionActivity extends AppCompatActivity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        mTextView = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_KEY);

        mTextView.setText(message);

    }
}
