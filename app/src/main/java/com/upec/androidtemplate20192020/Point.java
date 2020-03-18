package com.upec.androidtemplate20192020;

import android.os.Parcel;
import android.os.Parcelable;

public class Point implements Parcelable {
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
