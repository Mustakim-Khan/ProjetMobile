package com.example.projetserver;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.Socket;

public class ClientAsync extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... v) {
        try {
            Socket s = new Socket("127.0.0.1", 1234);
            System.out.println("je suis connecté");

        } catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Je ne suis pas connecté");
        }

        return null ;

    }
}
