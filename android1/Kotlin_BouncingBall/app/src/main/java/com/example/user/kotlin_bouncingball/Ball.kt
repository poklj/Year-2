package com.example.user.kotlin_bouncingball

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import java.util.*


class Ball{
    internal var radius = 50f      // Ball's radius
    internal var x: Float = 0.toFloat()                // Ball's center (x,y)
    internal var y: Float = 0.toFloat()
    internal var speedX: Float = 0.toFloat()           // Ball's speed
    internal var speedY: Float = 0.toFloat()

    protected lateinit var bounds: RectF   // Needed for Canvas.drawOval
    protected lateinit var paint: Paint    // The paint style, color used for drawing

    internal var ax : Double = 0.toDouble()
    internal var ay : Double = 0.toDouble()
    internal var az : Double = 0.toDouble()

    fun setAcc(ax : Double, ay : Double, az : Double){
        this.ax = ax
        this.ay = ay
        this.az = az
    }
    val r : Random = Random()

    constructor(color : Int){
        bounds = RectF()
        paint = Paint()
        paint.color = color

        // random position and speed
        x = radius + r.nextInt(800)
        y = radius + r.nextInt(800)
        speedX = (r.nextInt(10) - 5).toFloat()
        speedY = (r.nextInt(10) - 5).toFloat()
    }

    constructor(color : Int, x : Float, y : Float, speedX : Float, speedY :Float){
        bounds = RectF()
        paint = Paint()
        paint.color = color

        // use parameter position and speed
        this.x = x
        this.y = y
        this.speedX = speedX
        this.speedY = speedY
    }

    fun moveWithCollisionDetection(box: Box) {
        // Get new (x,y) position
        x += speedX
        y += speedY

        // Add acceleration to speed
        speedX += ax.toFloat()
        speedY += ay.toFloat()

        // Detect collision and react
        if (x + radius > box.xMax) {
            speedX = -speedX
            x = box.xMax - radius
        } else if (x - radius < box.xMin) {
            speedX = -speedX
            x = box.xMin + radius
        }
        if (y + radius > box.yMax) {
            speedY = -speedY
            y = box.yMax - radius
        } else if (y - radius < box.yMin) {
            speedY = -speedY
            y = box.yMin + radius
        }
    }

    fun Checkifcolide(target: RectF): Boolean {
        var result = false

        if (this.bounds.intersect(target)) {
            result = true
        }
        return result
    }

    fun draw(canvas: Canvas) {
        bounds.set(x - radius, y - radius, x + radius, y + radius)
        canvas.drawOval(bounds, paint)
    }

}