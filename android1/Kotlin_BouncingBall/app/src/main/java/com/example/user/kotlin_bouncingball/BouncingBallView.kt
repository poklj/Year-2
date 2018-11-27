package com.example.user.kotlin_bouncingball

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.util.Log
import android.view.MotionEvent
import android.view.View
import java.util.*

@SuppressLint("ViewConstructor")
class BouncingBallView : View, SensorEventListener {


    private var balls = arrayListOf<Ball>()
    private var squares = arrayListOf<Square>()
    private var ball_1: Ball
    private var box : Box = Box(Color.WHITE)

    private val  statusMsg : StringBuilder = java.lang.StringBuilder()
    private val formatter : Formatter = Formatter(statusMsg)
    private var paint : Paint

    private var string_line : Int = 1
    private var string_x : Int = 10
    private val string_line_size : Int = 40
    var score : Int = 0

    private var debug_dump1 = arrayListOf<String>()
   // private lateinit var debug_dump2 : String[] = String[200]
    private var previousX : Float = 0.0f
    private var previousY : Float = 0.0f


    private val r : Random = Random()


    constructor(context : Context) : super(context){ //This is super jank, Apparently Kotlin is Aware of What is Extending and interfacing... or are the the same thing

        // ARGB

        //ball_1 = new Ball(Color.GREEN);
        balls.add(Ball(Color.GREEN))
        ball_1 = balls[0]  // points ball_1 to the first; (zero-ith) element of list
        Log.w("BouncingBallLog", "Just added a bouncing ball")

        //ball_2 = new Ball(Color.CYAN);
        balls.add(Ball(Color.CYAN))
        Log.w("BouncingBallLog", "Just added another bouncing ball")

        // Set up status message on paint object
        paint = Paint()

        // Set the font face and size of drawing text
        paint.typeface = Typeface.MONOSPACE
        paint.textSize = 32f
        paint.color = Color.CYAN

        // To enable keypad
        this.isFocusable = true
        this.requestFocus()
        // To enable touch mode
        this.isFocusableInTouchMode = true
    }

    override fun onDraw(canvas: Canvas) {

        // Draw the component
        box.draw(canvas)
        //canvas.drawARGB(0,25,25,25);
        //canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        for (b in balls) {
            b.draw(canvas)  //draw each ball in the list
            b.moveWithCollisionDetection(box)  // Update the position of the ball
        }
        for (s in squares) {
            s.draw(canvas)  //draw each ball in the list
            s.moveWithCollisionDetection(box)  // Update the position of the ball
        }
        for (b in balls) {
            for (s in squares) {
                if (b.Checkifcolide(s.bounds)) {
                    score++
                    Log.w("Score", "Score is:$score")
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
            string_line = 1  // first line is status
            debug_dump1.clear()
        } else {
            string_line++
        }

        // inc-rotate string_x
        if (string_x > box.xMax) {
            string_x = 10  // first line is status
        } else {
            string_x++
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
        this.invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val currentX = event.x
        val currentY = event.y
        val deltaX: Float
        val deltaY: Float
        val scalingFactor = 5.0f / if (box.xMax > box.yMax) box.yMax else box.xMax
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                // Modify rotational angles according to movement
                if (currentX - previousX > 5 || currentY - previousY > 5) {
                    deltaX = currentX - previousX
                    deltaY = currentY - previousY
                    ball_1.speedX += deltaX * scalingFactor
                    ball_1.speedY += deltaY * scalingFactor
                    //Log.w("BouncingBallLog", " Xspeed=" + ball_1.speedX + " Yspeed=" + ball_1.speedY);
                    Log.w("BouncingBallLog", "x,y= $previousX ,$previousY  Xdiff=$deltaX Ydiff=$deltaY")
                    balls.add(
                        Ball(
                            Color.argb(255, r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                            previousX,
                            previousY,
                            deltaX,
                            deltaY
                        )
                    )  // add ball at every touch event
                } else {
                    deltaX = currentX - previousX
                    deltaY = currentY - previousY
                    ball_1.speedX += deltaX * scalingFactor
                    ball_1.speedY += deltaY * scalingFactor
                    //Log.w("BouncingBallLog", " Xspeed=" + ball_1.speedX + " Yspeed=" + ball_1.speedY);
                    Log.w("BouncingBallLog", "x,y= $previousX ,$previousY  Xdiff=$deltaX Ydiff=$deltaY")
                    squares.add(
                        Square(
                            Color.argb(255, r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                            previousX,
                            previousY,
                            deltaX,
                            deltaY
                        )
                    )

                }


                // A way to clear list when too many balls
                if (balls.size > Integer.MAX_VALUE) {
                    // leave first ball, remove the rest
                    Log.v("BouncingBallLog", "too many balls, clear back to 1")
                    balls.clear()
                    squares.clear()
                    balls.add(Ball(Color.RED))
                    ball_1 = balls[0]  // points ball_1 to the first (zero-ith) element of list
                }
            }
        }
        // Save current x, y
        previousX = currentX
        previousY = currentY

        // Try this (remove other invalidate(); )
        //this.invalidate();

        return true  // Event handled
    }

    // Called back when the view is first created or its size changes.
    public override fun onSizeChanged(w: Int, h: Int, oldW: Int, oldH: Int) {
        // Set the movement bounds for the ball
        box.set(0, 0, w, h)
        Log.w("BouncingBallLog", "onSizeChanged w=$w h=$h")
    }

    override fun onSensorChanged(event: SensorEvent) {

        Log.v("onSensorChanged", "event=" + event.toString())

        // Lots of sensor types...get which one, unpack accordingly
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val ax = event.values[0].toDouble()
            val ay = event.values[1].toDouble()
            val az = event.values[2].toDouble()

            for (b in balls) {
                b.setAcc(ax / 3, ay / 3, az / 3)  //acc for each ball
            }

            Log.v("onSensorChanged", "ax=$ax ay=$ay az=$az")
        }
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        Log.v("onAccuracyChanged", "event=" + sensor.toString())
    }

}

