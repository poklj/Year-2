package com.example.russ.m08_net_01;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

import com.example.russ.m08_net_01.client.Box_Android;
import com.example.russ.m08_net_01.client.MovingDot_Android;
import com.example.russ.m08_net_01.common.P6_ClientServerStart;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.concurrent.Executors;

/**
 * Created by Russ on 08/04/2014.
 */
public class BouncingBallView extends View {

    private ArrayList<MovingDot_Android> balls = new ArrayList<MovingDot_Android>(); // list of Balls
    private Box_Android box;

    // Status message to show Ball's (x,y) position and speed.
    private StringBuilder statusMsg = new StringBuilder();
    private Formatter formatter = new Formatter(statusMsg);
    private Paint paint;

    // For touch inputs - previous touch (x, y)
    private float previousX;
    private float previousY;

    // Constructor
    public BouncingBallView(Context context) {
        super(context);

        // Set up network on another thread
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // set up network
                P6_ClientServerStart.main(null);   // old network start up code

                // create the box
                box = new Box_Android(Color.YELLOW);  // ARGB
                P6_ClientServerStart.localClient.setBox(box);  // Client needs bounds, all balls created on network
                Log.w("BouncingBallLog", "box = new Box_Android");

            }
        });


//        //ball_1 = new Ball(Color.GREEN);
//        balls.add(new MovingDot_Android(box, Color.GREEN));
//        ball_1 = balls.get(0);  // points ball_1 to the first; (zero-ith) element of list
//        Log.w("BouncingBallLog", "Just added a bouncing ball");
//
//        //ball_2 = new Ball(Color.CYAN);
//        balls.add(new MovingDot_Android(box, Color.CYAN));
//        Log.w("BouncingBallLog", "Just added another bouncing ball");

        // Set up status message on paint object
        paint = new Paint();

        // Set the font face and size of drawing text
//        paint.setTypeface(Typeface.MONOSPACE);
//        paint.setTextSize(32);
//        paint.setColor(Color.CYAN);

        // To enable keypad
        this.setFocusable(true);
        this.requestFocus();
        // To enable touch mode
        this.setFocusableInTouchMode(true);


        Log.w("BouncingBallLog", "BouncingBallView");
    }

    // Called back to draw the view. Also called after invalidate().
    @Override
    protected void onDraw(Canvas canvas) {
        // Draw the components
        if (box != null) {
            box.draw(canvas);
            for (MovingDot_Android b : balls) {
                b.draw(canvas);  //draw each ball in the list
                //b.moveWithCollisionDetection(box);  // Update the position of the ball
            }
        }
        if (P6_ClientServerStart.localClient != null) {
            P6_ClientServerStart.localClient.onDrawAll(canvas);
            //this.invalidate();
        }

        // Draw the status message to the screen
//        statusMsg.delete(0, statusMsg.length());   // Empty buffer
//        formatter.format("Ball@(%3.0f,%3.0f),Speed=(%2.0f,%2.0f)", ball_1.x, ball_1.y,
//                ball_1.speedX, ball_1.speedY);
//        canvas.drawText(statusMsg.toString(), 10, 30, paint);

        // Delay on UI thread causes big problems!
        // Simulates doing busy work or waits on UI (DB connections, Network I/O, ....)
        //  I/Choreographer? Skipped 64 frames!  The application may be doing too much work on its main thread.
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//        }

        // Check what happens if you draw the box last
        //box.draw(canvas);

        Log.w("BouncingBallLog", "onDraw");

        // Check what happens if you don't call invalidate (redraw only when stopped-started)
        // Force a re-draw
        this.invalidate();
    }

    // Called back when the view is first created or its size changes.
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        // Set the movement bounds for the ball
        if (box!=null) {
            box.set(0, 0, w, h);
        }
        Log.w("BouncingBallLog", "onSizeChanged w=" + w + " h=" + h);
    }


    // Touch-input handler
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.w("BouncingBallLog", "event=" + event.toString());

        float currentX = event.getX();
        float currentY = event.getY();
        float deltaX, deltaY;
        float scalingFactor = 5.0f / 100.0f;

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                // Modify rotational angles according to movement
                deltaX = currentX - previousX;
                deltaY = currentY - previousY;
                //Log.w("BouncingBallLog", " Xspeed=" + ball_1.speedX + " Yspeed=" + ball_1.speedY);
                //Log.w("BouncingBallLog", "x,y= " + previousX + " ," + previousY + "  Xdiff=" + deltaX + " Ydiff=" + deltaY);
                //balls.add(new Ball(Color.RED, previousX, previousY, deltaX, deltaY));  // add ball at every touch event

                P6_ClientServerStart.localClient.newBird(currentX, currentY, deltaX, deltaY);

                // A way to clear list when too many balls
                if (P6_ClientServerStart.localClient.ballCount() > 400) {
                    // leave first ball, remove the rest
                    Log.v("BouncingBallLog", "too many balls, clear back to 1");
                    P6_ClientServerStart.localClient.resetAll();
//                    balls.clear();
//                    balls.add(new Ball(Color.GREEN));
                    //ball_1 = balls.get(0);  // points ball_1 to the first (zero-ith) element of list
                }

        }
        // Save current x, y
        previousX = currentX;
        previousY = currentY;

        return true;  // Event handled
    }

}
