package com.example.russ.m03_bounce2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;

/**
 * Created by Russ on 08/04/2014.
 */
public class BouncingBallView extends View implements SensorEventListener {

    private ArrayList<Ball> balls = new ArrayList<Ball>(); // list of Balls
    private ArrayList<Square> squares = new ArrayList<Square>();
    private Ball ball_1;  // use this to reference first ball in arraylist
    private Box box;

    // Status message to show Ball's (x,y) position and speed.
    private StringBuilder statusMsg = new StringBuilder();
    private Formatter formatter = new Formatter(statusMsg);
    private Paint paint;

    private int string_line = 1;  //
    private int string_x = 10;
    private int string_line_size = 40;  // pixels to move down one line
    private int score = 0;
    private ArrayList<String> debug_dump1 = new ArrayList();
    private String[] debug_dump2 = new String[200];

    // For touch inputs - previous touch (x, y)
    private float previousX;
    private float previousY;

    private Random r = new Random();
    // Constructor
    public BouncingBallView(Context context) {
        super(context);

        // Init the array
        for (int i = 1; i < 200; i++) {
            debug_dump2[i] = "  ";
        }

        // create the box
        box = new Box(Color.WHITE);  // ARGB

        //ball_1 = new Ball(Color.GREEN);
        balls.add(new Ball(Color.GREEN));
        ball_1 = balls.get(0);  // points ball_1 to the first; (zero-ith) element of list
        Log.w("BouncingBallLog", "Just added a bouncing ball");

        //ball_2 = new Ball(Color.CYAN);
        balls.add(new Ball(Color.CYAN));
        Log.w("BouncingBallLog", "Just added another bouncing ball");

        // Set up status message on paint object
        paint = new Paint();

        // Set the font face and size of drawing text
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextSize(32);
        paint.setColor(Color.CYAN);

        // To enable keypad
        this.setFocusable(true);
        this.requestFocus();
        // To enable touch mode
        this.setFocusableInTouchMode(true);
    }

    // Called back to draw the view. Also called after invalidate().
    @Override
    protected void onDraw(Canvas canvas) {

        // Draw the component
        box.draw(canvas);
        //canvas.drawARGB(0,25,25,25);
        //canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        for (Ball b : balls) {
            b.draw(canvas);  //draw each ball in the list
            b.moveWithCollisionDetection(box);  // Update the position of the ball
        }
        for (Square s : squares) {
            s.draw(canvas);  //draw each ball in the list
            s.moveWithCollisionDetection(box);  // Update the position of the ball
        }
        for (Ball b : balls){
            for (Square s : squares){
                if (b.Checkifcolide(s.bounds)){
                    score++;
                    Log.w("Score","Score is:" + score);
                }
            }
        }

        // Draw the status message to the screen
//        statusMsg.delete(0, statusMsg.length());   // Empty buffer
//        formatter.format("Ball@(%3.0f,%3.0f),Speed=(%2.0f,%2.0f)", ball_1.x, ball_1.y,
//                ball_1.speedX, ball_1.speedY);
//        canvas.drawText(statusMsg.toString(), 10, 30, paint);


        // inc-rotate string_line
        if (string_line * string_line_size > box.yMax) {
            string_line = 1;  // first line is status
            debug_dump1.clear();
        } else {
            string_line++;
        }

        // inc-rotate string_x
        if (string_x > box.xMax) {
            string_x = 10;  // first line is status
        } else {
            string_x++;
        }

        // Array of String (uses more mem, but changes less)
//        debug_dump2[string_line] = "Ball(" + balls.size() + " " + ball_1.x + " ," + ball_1.y + ")";
//        for (int i = 1; i < debug_dump2.length; i++) {
//            canvas.drawText(debug_dump2[i], string_x, i * string_line_size, paint);
//        }

        // ArrayList (more new's, allocation of RAM)
//        String newString = new String("AL-Ball(" + string_line + "  " + ball_1.x + " ," + ball_1.y + ") ");
//        debug_dump1.add(newString);
//        for (int i = 1; i < debug_dump1.size(); i++) {
//            canvas.drawText(debug_dump1.get(i), 700, i * string_line_size, paint);
//        }


        // Delay on UI thread causes big problems!
        // Simulates doing busy work or waits on UI (DB connections, Network I/O, ....)
        //  I/Choreographer? Skipped 64 frames!  The application may be doing too much work on its main thread.
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//        }

        // Check what happens if you draw the box last
        //box.draw(canvas);

        // Check what happens if you don't call invalidate (redraw only when stopped-started)
        // Force a re-draw
        this.invalidate();
    }

    // Called back when the view is first created or its size changes.
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        // Set the movement bounds for the ball
        box.set(0, 0, w, h);
        Log.w("BouncingBallLog", "onSizeChanged w=" + w + " h=" + h);
    }


    // Touch-input handler
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX = event.getX();
        float currentY = event.getY();
        float deltaX, deltaY;
        float scalingFactor = 5.0f / ((box.xMax > box.yMax) ? box.yMax : box.xMax);
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                // Modify rotational angles according to movement
                if(currentX - previousX > 5 || currentY - previousY > 5) {
                    deltaX = currentX - previousX;
                    deltaY = currentY - previousY;
                    ball_1.speedX += deltaX * scalingFactor;
                    ball_1.speedY += deltaY * scalingFactor;
                    //Log.w("BouncingBallLog", " Xspeed=" + ball_1.speedX + " Yspeed=" + ball_1.speedY);
                    Log.w("BouncingBallLog", "x,y= " + previousX + " ," + previousY + "  Xdiff=" + deltaX + " Ydiff=" + deltaY);
                    balls.add(new Ball(Color.argb(255, r.nextInt(255), r.nextInt(255), r.nextInt(255)), previousX, previousY, deltaX, deltaY));  // add ball at every touch event
                } else {
                    deltaX = currentX - previousX;
                    deltaY = currentY - previousY;
                    ball_1.speedX += deltaX * scalingFactor;
                    ball_1.speedY += deltaY * scalingFactor;
                    //Log.w("BouncingBallLog", " Xspeed=" + ball_1.speedX + " Yspeed=" + ball_1.speedY);
                    Log.w("BouncingBallLog", "x,y= " + previousX + " ," + previousY + "  Xdiff=" + deltaX + " Ydiff=" + deltaY);
                    squares.add(new Square(Color.argb(255, r.nextInt(255), r.nextInt(255), r.nextInt(255)), previousX, previousY, deltaX, deltaY));

                }



                // A way to clear list when too many balls
                if (balls.size() > Integer.MAX_VALUE) {
                    // leave first ball, remove the rest
                    Log.v("BouncingBallLog", "too many balls, clear back to 1");
                    balls.clear();
                    squares.clear();
                    balls.add(new Ball(Color.RED));
                    ball_1 = balls.get(0);  // points ball_1 to the first (zero-ith) element of list
                }

        }
        // Save current x, y
        previousX = currentX;
        previousY = currentY;

        // Try this (remove other invalidate(); )
        //this.invalidate();

        return true;  // Event handled
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        Log.v("onSensorChanged", "event=" + event.toString());

        // Lots of sensor types...get which one, unpack accordingly
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            double ax = event.values[0];
            double ay = event.values[1];
            double az = event.values[2];

            for (Ball b : balls) {
                b.setAcc(ax / 3, ay / 3, az / 3);  //acc for each ball
            }

            Log.v("onSensorChanged", "ax=" + ax + " ay=" + ay + " az=" + az);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.v("onAccuracyChanged", "event=" + sensor.toString());
    }

}
