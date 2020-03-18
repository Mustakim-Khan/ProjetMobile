package com.upec.androidtemplate20192020;

import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread implements Runnable {

    private Socket s ;
    private String host ;

    public ClientThread(String string){
        host = string ;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(host, 12345);
            this.s = socket;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}