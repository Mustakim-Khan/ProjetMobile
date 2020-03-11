package com.example.projetserver;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.Socket;

public class Client extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client);
        ClientAsync asyncTask = new ClientAsync();
        asyncTask.execute();
    }
}



