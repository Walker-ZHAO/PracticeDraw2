package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice12PathEffectView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal val path = Path()
    val path1 = Path()
    val cornerEffect: CornerPathEffect
    val discreteEffect: DiscretePathEffect
    val dashEffect: DashPathEffect
    val pathEffect: PathDashPathEffect
    val sumEffect: SumPathEffect
    val composeEffect: ComposePathEffect

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.style = Paint.Style.STROKE

        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)

        path1.rLineTo(10f, 17.5f)
        path1.rLineTo(-10f, 17.5f)
        path1.close()

        cornerEffect = CornerPathEffect(10f)
        discreteEffect = DiscretePathEffect(20f, 5f)
        dashEffect = DashPathEffect(floatArrayOf(20f, 5f, 10f, 5f), 0f)
        pathEffect = PathDashPathEffect(path1, 20f, 0f, PathDashPathEffect.Style.MORPH)
        sumEffect = SumPathEffect(discreteEffect, dashEffect)
        composeEffect = ComposePathEffect(dashEffect, discreteEffect)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        paint.pathEffect = cornerEffect
        canvas.drawPath(path, paint)

        canvas.save()
        canvas.translate(500f, 0f)
        // 第二处：DiscretePathEffect
        paint.pathEffect = discreteEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 200f)
        // 第三处：DashPathEffect
        paint.pathEffect = dashEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 200f)
        // 第四处：PathDashPathEffect
        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 400f)
        // 第五处：SumPathEffect
        paint.pathEffect = sumEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 400f)
        // 第六处：ComposePathEffect
        paint.pathEffect = composeEffect
        canvas.drawPath(path, paint)
        canvas.restore()
    }
}
