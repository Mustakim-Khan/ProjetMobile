package com.example.testclientserver;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.Socket;

public class Client extends AppCompatActivity implements Runnable {

    private Socket s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client);

    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 12345);
            this.s = socket ;
            System.out.println("Je suis connecté");
        } catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }

    public Socket getS (){
        return s ;
    }
}
