package com.example.jafoole.notificationshw;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabTextMessage;
    FloatingActionButton fabInboxStyle;
    FloatingActionButton fabScreenShot;
    FloatingActionButton fabTestTitle;
    FloatingActionButton fabInstagram;
    FloatingActionButton fabUSBDebugging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO: TOP THREE FOR SIMON

        FloatingActionButton fabTextMessage = (FloatingActionButton) findViewById(R.id.fabTextMessage);
        fabTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fabInboxStyle = (FloatingActionButton) findViewById(R.id.fabInboxStyle);
        fabInboxStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fabScreenShot = (FloatingActionButton) findViewById(R.id.fabScreenShot);
        fabScreenShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //TODO: END TOP THREE


        ///
        ///
        ///


        //TODO: BOTTOM THREE FOR CHRIS


        FloatingActionButton fabTestTitle = (FloatingActionButton) findViewById(R.id.fabTestTitle);
        fabTestTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fabInstagram = (FloatingActionButton) findViewById(R.id.fabInstagram);
        fabInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        FloatingActionButton fabUSBDebugging = (FloatingActionButton) findViewById(R.id.fabUSBDebugging);
        fabUSBDebugging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //TODO: END BUTTON THREE

    }

}
