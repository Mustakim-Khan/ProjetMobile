package com.upec.androidtemplate20192020;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Client extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Dessin d = findViewById(R.id.dessin);
        Button b = findViewById(R.id.button);

        if (savedInstanceState != null) {
            d.thickness = savedInstanceState.getFloat("thickness");
            d.setPoints(savedInstanceState.<Point>getParcelableArrayList("liste"));
        }

        Intent intent = getIntent();
        String host = intent.getStringExtra("client");
        if (host.equals("localhost")) {
            new Thread(new ServerThread()).start();
        }

        ClientThreadSend clientsend = new ClientThreadSend(host);
        clientsend.start();
        while (!clientsend.isReady()) ;
        if (clientsend.isErreurConnexion()) {
            setResult(Activity.RESULT_OK);
                finish();
        } else {
                new ClientThreadReceive(clientsend.getS()).start();
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dessin d = findViewById(R.id.dessin);
                Intent intent = new Intent(Client.this, Palette.class);
                intent.putExtra("thickness", d.thickness);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            Dessin d = findViewById(R.id.dessin);
            d.thickness = data.getFloatExtra("thickness", d.thickness);
            d.color = data.getIntExtra("color", Color.BLACK);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Dessin d = findViewById(R.id.dessin);
        outState.putFloat("thickness", d.thickness);
        outState.putParcelableArrayList("liste", d.points);
        outState.putInt("color", d.color);
        super.onSaveInstanceState(outState);
    }


}
