package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.service.quicksettings.Tile
import android.util.AttributeSet
import android.view.View

class Practice02RadialGradientView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val radialGradient: RadialGradient

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
        radialGradient = RadialGradient(300f, 300f, 200f, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.shader = radialGradient

        canvas.drawCircle(300f, 300f, 200f, paint)
    }
}
