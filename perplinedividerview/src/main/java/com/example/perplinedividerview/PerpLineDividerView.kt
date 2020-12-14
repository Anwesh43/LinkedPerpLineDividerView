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

