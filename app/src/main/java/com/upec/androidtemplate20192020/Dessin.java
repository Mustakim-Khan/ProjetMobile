package com.upec.androidtemplate20192020;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Dessin extends View {
    public ArrayList<Point> points;
    public float thickness;
    public int color;
    public Dessin(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        points = new ArrayList<>();
        thickness = 15;
        color = Color.BLACK;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Point pt = null;
        for(Point p : points)
        {
            if(pt !=null)
            {
                canvas.drawLine(pt.x, pt.y, p.x, p.y, paint);
            }
            Log.d("Thickness in onDraw", Float.toString(p.thickness));
            paint.setStrokeWidth(p.thickness);
            paint.setColor(p.color);
            canvas.drawPoint(p.x, p.y, paint);
            pt = p;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP)
        {
            points.add(new Point(event.getX(), event.getY(), thickness, Color.TRANSPARENT));
        }
        else
        {
            points.add(new Point(event.getX(), event.getY(), thickness, color));
        }
        invalidate();
        return true;
    }

    public ArrayList<Point> getPoints()
    {
        return points;
    }

    public void setPoints(ArrayList<Point> points)
    {
        this.points = points;
    }

}
