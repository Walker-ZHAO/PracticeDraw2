package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw2.R

class Practice07ColorMatrixColorFilterView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal val bitmap: Bitmap
    val colorMatrix: ColorMatrix
    val matrixColorFilter: ColorMatrixColorFilter

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

        // 使用 setColorFilter() 设置一个 ColorMatrixColorFilter
        // 用 ColorMatrixColorFilter.setSaturation() 把饱和度去掉
        colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)
        matrixColorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.colorFilter = matrixColorFilter

        canvas.drawBitmap(bitmap, 0f, 0f, paint)
    }
}
