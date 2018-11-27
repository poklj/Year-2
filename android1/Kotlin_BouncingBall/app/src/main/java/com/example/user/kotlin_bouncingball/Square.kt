package com.example.user.kotlin_bouncingball

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import java.util.*

class Square{

    val radius : Float = 50f
    var x : Float = 0.0f
    var y : Float = 0.0f

    var speedX : Float = 0.0f
    var speedY : Float = 0.0f

    var bounds : RectF
    protected var paint : Paint

    private var ax : Float = 0.0f
    private var ay : Float = 0.0f
    private var az : Float = 0.0f

    fun setAcc(ax : Double, ay : Double, az : Double){
        this.ax = ax.toFloat()
        this.ay = ay.toFloat()
        this.az = az.toFloat()
    }

    val r : Random = Random()


    constructor(color : Int) {
        bounds = RectF()
        paint = Paint()
        paint.color = color

        x = radius + r.nextInt(800)
        y = radius + r.nextInt(800)

        speedX = (r.nextInt(10) - 5).toFloat()
        speedY = (r.nextInt(10) - 5).toFloat()
    }
    constructor(color : Int, x : Float, y : Float, speedX : Float, speedY : Float ) {
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
        speedX += ax
        speedY += ay

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
        canvas.drawRect(bounds, paint)
    }
}