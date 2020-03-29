package com.upec.androidtemplate20192020;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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
        Intent intent = getIntent() ;
        final float t = intent.getFloatExtra("thickness", 15);
        final int c = intent.getIntExtra("color", Color.BLACK);
        Button b = findViewById(R.id.ok);
        TextView thickness = findViewById(R.id.thickness);
        thickness.setHint(String.valueOf(t));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView thickness = findViewById(R.id.thickness);
                Intent in = new Intent();
                try {
                    in.putExtra("thickness", Float.valueOf(thickness.getText().toString()));
                    in.putExtra("color", c);
                } catch (NumberFormatException e) {};
                setResult(Activity.RESULT_OK, in);
                finish();
            }
        });

        Button bleu = findViewById(R.id.buttonbleu);
        Button vert = findViewById(R.id.buttonvert);
        Button rouge = findViewById(R.id.buttonrouge);
        Button noir = findViewById(R.id.buttonnoir);
        Button gomme = findViewById(R.id.buttongomme);

        bleu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.putExtra("thickness", t);
                in.putExtra("color", Color.BLUE);
                setResult(Activity.RESULT_OK, in);
                finish();
            }
        });

        noir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.putExtra("thickness", t);
                in.putExtra("color", Color.BLACK);
                setResult(Activity.RESULT_OK, in);
                finish();
            }
        });

        rouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.putExtra("thickness", t);
                in.putExtra("color", Color.RED);
                setResult(Activity.RESULT_OK, in);
                finish();
            }
        });

        vert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.putExtra("thickness", t);
                in.putExtra("color", Color.GREEN);
                setResult(Activity.RESULT_OK, in);
                finish();
            }
        });

        gomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.putExtra("thickness", t);
                in.putExtra("color", Color.WHITE);
                setResult(Activity.RESULT_OK, in);
                finish();
            }
        });

    }

}
