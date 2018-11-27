package com.example.user.kotlin_bouncingball

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import android.view.View
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import java.util.ArrayList
import java.util.List

class MainActivity : AppCompatActivity() {
    private var bouncingBallView : View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.bouncingBallView = BouncingBallView(this)
        setContentView(bouncingBallView)
    }

    override fun onResume(){
        super.onResume()
        if( this.bouncingBallView != null ) {
            Log.v("SENSORS", "onResume bouncingBallView=" + bouncingBallView.toString())

            if(my_Sensor != null){
                Log.v("SENSORS", "onResume my_Sensor=" + my_Sensor.toString())
                mSensorManager?.registerListener(
                    bouncingBallView as SensorEventListener,
                    my_Sensor,
                    SensorManager.SENSOR_DELAY_NORMAL
                )
            }
        } else {
            Log.v("SENSORS", "onResume bouncingBallView=null")
        }
        Log.v("SENSORS", "onResume ACCELLEROMETER")
    }
    // Each of the things with !! are asserted Not null
    override fun onPause() {
        super.onPause()
        mSensorManager?.unregisterListener(bouncingBallView as SensorEventListener)
        Log.v("SENSORS", "onPause ACCELLEROMETER")
    }

    private var mSensorManager: SensorManager? = null
    private var my_Sensor: Sensor? = null
    internal var deviceSensors: kotlin.collections.List<Sensor> = ArrayList()

    private fun setupSensors() {
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        deviceSensors = mSensorManager!!.getSensorList(Sensor.TYPE_ALL)
        Log.v("SENSORS", "Sensor List=" + deviceSensors.toString())

        // Use the accelerometer.
        if (mSensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            my_Sensor = mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

            //my_Sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
            Log.v("SENSORS", "my_Sensor=" + my_Sensor.toString())
        } else {
            // Sorry, there are no accelerometers on your device.
            // You can't play this game.
            Log.v("SENSORS", "NO SENSOR TYPE?")
        }

    }

}

