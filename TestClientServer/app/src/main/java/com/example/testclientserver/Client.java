package com.example.testclientserver;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Client extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        new Thread(new ServerThread()).start() ;
        ClientThread client = new ClientThread();
        client.start();

    }

}
