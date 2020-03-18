package com.upec.androidtemplate20192020;

import android.content.Intent;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Client extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Intent intent = getIntent();
        String host = intent.getStringExtra("client");
        if (host.equals("127.0.0.1")){
            new Thread(new ServerThread()).start() ;
        }
        ClientThread client = new ClientThread(host);
        client.start();

        Dessin d = findViewById(R.id.dessin);
        Button b = findViewById(R.id.button);

        ArrayList<Point> points = null;


        if(savedInstanceState != null)
        {
            d.thickness = savedInstanceState.getFloat("thickness");
            //Log.d("thick in SAVED", Float.toString(savedInstanceState.getFloat("thickness")));
            d.setPoints(savedInstanceState.<com.upec.androidtemplate20192020.Point>getParcelableArrayList("liste"));
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Log.d("MSGGGG", String.valueOf(userList.isEmpty()));
                Intent intent = new Intent(Client.this, Palette.class);
                startActivityForResult(intent,  1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            Dessin d = findViewById(R.id.dessin);
            d.thickness = data.getFloatExtra("thickness", d.thickness);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Dessin d = findViewById(R.id.dessin);
        outState.putFloat("thickness", d.thickness);
        //Log.d("thick", Float.toString(d.thickness));
        outState.putParcelableArrayList("liste", d.points);
        super.onSaveInstanceState(outState);
    }
    //salut


}
