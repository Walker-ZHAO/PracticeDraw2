package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw2.R

class Practice08XfermodeView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal val bitmap1: Bitmap
    internal val bitmap2: Bitmap
    val porterDuffXfermode1: PorterDuffXfermode
    val porterDuffXfermode2: PorterDuffXfermode
    val porterDuffXfermode3: PorterDuffXfermode

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        porterDuffXfermode1 = PorterDuffXfermode(PorterDuff.Mode.SRC)
        porterDuffXfermode2 = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        porterDuffXfermode3 = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 paint.setXfermode() 设置不同的结合绘制效果

        // 别忘了用 canvas.saveLayer() 开启 off-screen buffer
        val result = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)

        canvas.drawBitmap(bitmap1, 0f, 0f, paint)
        // 第一个：PorterDuff.Mode.SRC
        paint.xfermode = porterDuffXfermode1
        canvas.drawBitmap(bitmap2, 0f, 0f, paint)
        paint.xfermode = null

        canvas.drawBitmap(bitmap1, (bitmap1.width + 100).toFloat(), 0f, paint)
        // 第二个：PorterDuff.Mode.DST_IN
        paint.xfermode = porterDuffXfermode2
        canvas.drawBitmap(bitmap2, (bitmap1.width + 100).toFloat(), 0f, paint)
        paint.xfermode = null

        canvas.drawBitmap(bitmap1, 0f, (bitmap1.height + 20).toFloat(), paint)
        // 第三个：PorterDuff.Mode.DST_OUT
        paint.xfermode = porterDuffXfermode3
        canvas.drawBitmap(bitmap2, 0f, (bitmap1.height + 20).toFloat(), paint)
        paint.xfermode = null

        // 用完之后使用 canvas.restore() 恢复 off-screen buffer
        canvas.restoreToCount(result)
    }
}
