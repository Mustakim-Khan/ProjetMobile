package com.upec.androidtemplate20192020.Server;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSocket extends Thread {
    private static final int PORT = 4567;

    @Override
    public void run() {
        try {
            ServerSocket listener = new ServerSocket(PORT);

            Log.d("MSG", "Waiting client connection");
            Socket client = listener.accept();
            Log.d("MSG", "Client accepted");
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            Log.d("MSG", "Client accejpted");
            e.printStackTrace();
        }
    }
}
