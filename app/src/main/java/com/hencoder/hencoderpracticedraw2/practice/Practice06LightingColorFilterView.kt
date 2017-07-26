package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw2.R

class Practice06LightingColorFilterView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal val bitmap: Bitmap
    val lightingColorFilter1: LightingColorFilter
    val lightingColorFilter2: LightingColorFilter

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        lightingColorFilter1 = LightingColorFilter(0x00FFFF, 0x000000)
        lightingColorFilter2 = LightingColorFilter(0xFFFFFF, 0x003000)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter

        // 第一个 LightingColorFilter：去掉红色部分
        paint.colorFilter = lightingColorFilter1
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        // 第二个 LightingColorFilter：增强绿色部分
        paint.colorFilter = lightingColorFilter2
        canvas.drawBitmap(bitmap, (bitmap.width + 100).toFloat(), 0f, paint)
    }
}
