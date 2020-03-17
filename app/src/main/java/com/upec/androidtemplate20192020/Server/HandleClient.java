package com.upec.androidtemplate20192020.Server;

import android.util.Log;

import com.upec.androidtemplate20192020.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HandleClient extends Thread {
    Socket client;
    PrintWriter os;
    BufferedReader is;
    public HandleClient(Socket client) throws IOException {
        this.client = client;
        os = new PrintWriter(client.getOutputStream(), true);
        is = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String s = is.readLine();
                switch(s) {
                    case "LOGIN":
                        login(is.readLine());
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void login(String ip)
    {

        Log.d("MSGGGG s", ip);
        MainActivity.userList.add(ip);
    }
}
