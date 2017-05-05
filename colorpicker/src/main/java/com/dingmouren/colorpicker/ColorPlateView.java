package com.dingmouren.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by dingmouren on 2017/5/4.
 */

public class ColorPlateView extends View {
    private static final String TAG = ColorPlateView.class.getName();
    private Paint mPaint;
    private LinearGradient mShaderVertical;
    private final float[] HSV = {1.f,1.f,1.f};

    public ColorPlateView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ColorPlateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

    }
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPaint == null){
            mPaint = new Paint();
            mShaderVertical = new LinearGradient(0.f,0.f,0.f,this.getMeasuredHeight(),0xffffffff,0xff000000, Shader.TileMode.CLAMP);//线性渐变
        }
        int rgb = Color.HSVToColor(HSV);
        LinearGradient shaderHorizontal = new LinearGradient(0.f,0.f,this.getMeasuredWidth(),0.f,0xffffffff,rgb,Shader.TileMode.CLAMP);
        ComposeShader composeShader = new ComposeShader(mShaderVertical,shaderHorizontal,PorterDuff.Mode.MULTIPLY );//混合渐变
        mPaint.setShader(composeShader);
        canvas.drawRect(0.f,0.f,this.getMeasuredWidth(),this.getMeasuredHeight(),mPaint);
    }

    /**
     * 设置色彩
     * @param hue
     */
    public void setHue(float hue){
        HSV[0] = hue;
        invalidate();
    }
}
