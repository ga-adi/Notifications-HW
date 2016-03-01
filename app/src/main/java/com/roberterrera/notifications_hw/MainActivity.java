package com.roberterrera.notifications_hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mTestTitle;
    Button mUSBDebugging;
    Button mTwitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestTitle = (Button) findViewById(R.id.button_testtitle);
        mUSBDebugging = (Button) findViewById(R.id.button_usbdebugging);
        mTwitter = (Button) findViewById(R.id.button_twitter);

        mTestTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mUSBDebugging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
