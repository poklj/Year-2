package com.example.russ.m04_gui_01;

import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class phoneParticulars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_particulars);

        String versionNum = Integer.toString(Build.VERSION.SDK_INT);
        Boolean afterKitKat = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT);

        TextView t = (TextView) findViewById(R.id.textView2);
        t.setText(" Version Number is " + versionNum);
        t.append("\n Build.DISPLAY = " + Build.DISPLAY.toString());
        t.append("\n getDisplayMetrics().densityDpi = " + getResources().getDisplayMetrics().densityDpi);
        t.append("\n getDisplayMetrics().density = " + getResources().getDisplayMetrics().density);
        t.append("\n getDisplayMetrics().xdpi = " + getResources().getDisplayMetrics().xdpi);
        t.append("\n getDisplayMetrics().ydpi = " + getResources().getDisplayMetrics().ydpi);
        t.append("\n getDisplayMetrics().heightPixels = " + getResources().getDisplayMetrics().heightPixels);
        t.append("\n getDisplayMetrics().widthPixels = " + getResources().getDisplayMetrics().widthPixels);


        t.append("\n THIS IS THE SCREEN SIZE OF ACTIVITY #2 " + getResources().getDisplayMetrics().heightPixels +"x" + getResources().getDisplayMetrics().widthPixels);
    }
}
