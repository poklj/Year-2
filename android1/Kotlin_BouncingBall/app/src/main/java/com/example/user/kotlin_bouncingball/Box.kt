package com.example.user.kotlin_bouncingball

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

class Box(color: Int){

    var xMin : Int = 0
    var xMax : Int = 0
    var yMin : Int = 0
    var yMax : Int = 0

    private var paint : Paint = Paint()
    private var bounds : Rect

    init {
        paint.color = color
        bounds = Rect()
    }

    fun set(x : Int, y : Int, width : Int, height : Int){
        xMin = x
        xMax = x + width - 1
        yMin = y
        yMax = y + height - 1

        bounds.set(xMin, yMin, xMax, yMax)
    }

    fun draw(canvas : Canvas){
        canvas.drawRect(bounds, paint)
    }
}