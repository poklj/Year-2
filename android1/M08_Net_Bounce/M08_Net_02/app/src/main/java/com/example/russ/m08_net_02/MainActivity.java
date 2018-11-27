package com.example.russ.m08_net_02;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.russ.m08_net_02.client.Box_Android;
import com.example.russ.m08_net_02.common.P6_Main_Start;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Add Bouncing Ball ... hard code Server IP (ok for emulator, bad for pys. device)
        // http://www3.ntu.edu.sg/home/ehchua/programming/android/Android_2D.html
//        View bouncingBallView = new BouncingBallView(this, "172.16.10.10");
//        setContentView(bouncingBallView);
    }


    public void sendMessage(View view) {

        EditText editText = (EditText) findViewById(R.id.server_ip);
        String Server_IP = editText.getText().toString();

        View bouncingBallView = new BouncingBallView(this, Server_IP);
        setContentView(bouncingBallView);

        Log.v("BouncingBallLog", "Start with Server IP = " + Server_IP);

    }

}
