package com.example.w0091766.M09_01_Web_Service_Client;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;


/**
 *  Revised Bouncing Ball example.  Chopped away
 *  as much as possible, those bits not needed
 *  other than to support old Android versions.
 *
 */
public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Add Bouncing Ball
        // http://www3.ntu.edu.sg/home/ehchua/programming/android/Android_2D.html
        View bouncingBallView = new BouncingBallView(this);
        setContentView(bouncingBallView);
    }

}
