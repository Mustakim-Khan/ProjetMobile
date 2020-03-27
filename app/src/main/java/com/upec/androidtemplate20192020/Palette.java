package com.upec.androidtemplate20192020;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Palette extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        Button b = findViewById(R.id.ok);
        //final TextView color = findViewById(R.id.color);
        final TextView thickness = findViewById(R.id.thickness);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                try {
                    //in.putExtra("color", Integer.valueOf(color.getText().toString()));
                    in.putExtra("thickness", Float.valueOf(thickness.getText().toString()));
                } catch (NumberFormatException e) {};
                //Log.d("thick in Palette", thickness.getText().toString());
                setResult(Activity.RESULT_OK, in);
                finish();
            }
        });
    }

}
