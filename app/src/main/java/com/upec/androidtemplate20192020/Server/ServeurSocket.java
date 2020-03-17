package com.upec.androidtemplate20192020.Server;

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
            while(true)
            {
                ServerSocket listener = new ServerSocket(PORT);
                Socket client = listener.accept();
                Log.d("MSGGGG", "Client accepted");
                new HandleClient(client).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
