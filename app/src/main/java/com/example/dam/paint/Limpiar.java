package com.example.dam.paint;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Limpiar extends View {

    public Limpiar(Context context) {
        super(context);
    }

    public Limpiar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pincel = new Paint();
        //fondo gris
        pincel.setColor(Color.WHITE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), pincel);


    }
}

