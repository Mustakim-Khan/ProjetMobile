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

class Point implements Parcelable {
    float x, y, thickness;
    int color;

    public Point(float coord_x, float coord_y, float t, int c)
    {
        x = coord_x;
        y = coord_y;
        thickness = t;
        color = c;
    }

    protected Point(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
        thickness = in.readFloat();
        color = in.readInt();
    }

    public static final Creator<Point> CREATOR = new Creator<Point>() {
        @Override
        public Point createFromParcel(Parcel in) {
            return new Point(in);
        }

        @Override
        public Point[] newArray(int size) {
            return new Point[size];
        }
    };

    public float getThickness() {
        return thickness;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(x);
        dest.writeFloat(y);
        dest.writeInt(color);
    }
}
public class Dessin extends View {
    ArrayList<Point> points;
    float thickness;
    int color;
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
