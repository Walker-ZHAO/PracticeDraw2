package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Practice05ComposeShaderView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val bitmap1: Bitmap
    val bitmap2: Bitmap
    val bitmapShader1: BitmapShader
    val bitmapShader2: BitmapShader
    val composeShader: ComposeShader

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null) // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader

        bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        bitmapShader1 = BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        bitmapShader2 = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        composeShader = ComposeShader(bitmapShader1, bitmapShader2, PorterDuff.Mode.DST_IN)

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.shader = composeShader

        canvas.drawCircle(200f, 200f, 200f, paint)
    }
}
