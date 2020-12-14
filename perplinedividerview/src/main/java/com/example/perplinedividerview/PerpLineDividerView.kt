package com.example.perplinedividerview

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.app.Activity
import android.content.Context

val colors : Array<Int> = arrayOf(
    "#F44336",
    "#673AB7",
    "#009688",
    "#4CAF50",
    "#FF9800"
).map {
    Color.parseColor(it)
}.toTypedArray()
val kParts : Int = 4
val parts : Int = 3
val scGap : Float = 0.02f / (parts + kParts)
val strokeFactor : Float = 90f
val sizeFactor : Float = 3.9f
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawPerpLineDivider(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val sc1 : Float = scale.divideScale(0, parts)
    val sc2 : Float = scale.divideScale(1, parts)
    val sc3 : Float = scale.divideScale(2, parts)
    val lSize : Float = (2 * size) / (kParts - 1)
    save()
    translate(w / 2, h / 2)
    drawLine(-size + 2 * size * sc3, 0f, -size + 2 * size * sc1, 0f, paint)
    for (j in 0..(kParts - 1)) {
        save()
        translate(lSize * j, 0f)
        drawLine(0f, 0f, 0f, -lSize * sc2.divideScale(0, parts), paint)
        restore()
    }
    restore()
}

fun Canvas.drawPLDNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    drawPerpLineDivider(scale, w, h, paint)
}

class PerpLineDividerView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}