package com.upec.androidtemplate20192020;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.upec.androidtemplate20192020.Client.ClientSocket;
import com.upec.androidtemplate20192020.Server.ServeurSocket;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ServeurSocket().start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ClientSocket c = new ClientSocket();
                c.start();
            }
        }).start();
        Dessin d = findViewById(R.id.dessin);
        Button b = findViewById(R.id.button);
        if(savedInstanceState != null)
        {
            d.thickness = savedInstanceState.getFloat("thickness");
            Log.d("thick in SAVED", Float.toString(savedInstanceState.getFloat("thickness")));
            d.setPoints(savedInstanceState.<Point>getParcelableArrayList("liste"));
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Log.d("MSGGGG", String.valueOf(userList.isEmpty()));

                Intent intent = new Intent(MainActivity.this, Palette.class);
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
            //d.color = data.getIntExtra("color", Color.BLACK);
            //d.color = data.getIntExtra("color", 1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Dessin d = findViewById(R.id.dessin);
        outState.putFloat("thickness", d.thickness);
        Log.d("thick", Float.toString(d.thickness));
        outState.putParcelableArrayList("liste", d.points);
        super.onSaveInstanceState(outState);
    }


}
