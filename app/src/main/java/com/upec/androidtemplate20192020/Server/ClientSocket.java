package com.upec.androidtemplate20192020.Server;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket extends Thread {
    private static final int PORT = 9090;
    private static final String HOST = "127.0.0.1";
    private Socket socket;

    @Override
    public void run() {
        try {
            socket = new Socket(HOST, PORT);
            Log.d("MSG", "Client is connected");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
