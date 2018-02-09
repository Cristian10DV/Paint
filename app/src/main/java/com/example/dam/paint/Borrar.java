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

public class Borrar extends View {

    private Bitmap mapaDeBits;
    private Canvas canvasFondo;

    public Borrar(Context context) {
        super(context);
    }

    public Borrar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pincel = new Paint();
        /* SIEMPRE*/
        //pintar una linea negra
        //creamos un lienzo a partir del mapa de bits
        canvas.drawBitmap(mapaDeBits, 0, 0, null);
        pincel.setColor(Color.WHITE);
        pincel.setStrokeWidth(20);
        pincel.setAntiAlias(true);
        //Pintar con el "dedo"
        pincel.setStyle(Paint.Style.STROKE);
        canvasFondo.drawPath(rectaPoligonal, pincel);

    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mapaDeBits = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvasFondo = new Canvas(mapaDeBits);
    }

    private float xi, yi, xf, yf;
    //pintar una recta poligonal
    private Path rectaPoligonal = new Path();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            //Pulso la pantalla
            case MotionEvent.ACTION_DOWN:
                xf = xi = x;
                yf = yi = y;
                //pintar una recta poligonal
                rectaPoligonal.reset();
                rectaPoligonal.moveTo(xi, yi);
                break;
            //Muevo el dedo por la pantalla
            case MotionEvent.ACTION_MOVE:
                //recta poligonal
                rectaPoligonal.quadTo(xi, yi, (x + xi) / 2, (y + yi) / 2);

                xi = xf;
                yi = yf;

                xf = x;
                yf = y;
                break;
            //levanto el dedo de la pantalla
            case MotionEvent.ACTION_UP:
                xi = xf;
                yi = yf;

                xf = x;
                yf = y;
                break;
        }
        invalidate();
        return true;
    }
}