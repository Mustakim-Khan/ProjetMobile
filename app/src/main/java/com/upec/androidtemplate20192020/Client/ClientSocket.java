package com.upec.androidtemplate20192020.Client;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket extends Thread {
    private static final int PORT = 4567;
    private static final String HOST = "127.0.0.1";
    private Socket socket;
    BufferedReader is;
    PrintWriter os;

    public ClientSocket()
    {
        try {
            socket = new Socket(HOST, PORT);
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void run() {
        try{
            os.println("LOGIN");
            Log.d("MSGGGG", "IN RUN");
            os.println("ICI");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
