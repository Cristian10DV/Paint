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

public class PintarRectas extends View {

    private Bitmap mapaDeBits;
    private Canvas canvasFondo;

    public PintarRectas(Context context) {
        super(context);
    }

    public PintarRectas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pincel = new Paint();

        canvas.drawBitmap(mapaDeBits, 0, 0, null);
        pincel.setColor(Color.BLACK);
        pincel.setStrokeWidth(20);

        if (pintando) {
            //Dibujar un circulo sin relleno
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawLine(xi, yi, xf, yf, pincel);
        }else {
            //Guardar el circulo sin relleno
            pincel.setStyle(Paint.Style.STROKE);
            canvasFondo.drawLine(xi, yi, xf, yf, pincel);
        }
    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mapaDeBits = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvasFondo = new Canvas(mapaDeBits);
    }

    private float xi, yi, xf, yf;
    private boolean pintando = false;


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            //Pulso la pantalla
            case MotionEvent.ACTION_DOWN:
                pintando = true;
                xf = xi = x;
                yf = yi = y;
                break;
            //Muevo el dedo por la pantalla
            case MotionEvent.ACTION_MOVE:

                xf = x;
                yf = y;
                break;
            //levanto el dedo de la pantalla
            case MotionEvent.ACTION_UP:
                pintando = false;

                xf = x;
                yf = y;
                break;
        }
        invalidate();
        return true;
    }
}
