package com.example.testclientserver;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread implements Runnable {

    private Socket s ;

    @Override
    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 12345);
            this.s = socket;
            //PrintWriter os = new PrintWriter(socket.getOutputStream());
            System.out.println("Je suis connecté");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
