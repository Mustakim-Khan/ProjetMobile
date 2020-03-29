package com.upec.androidtemplate20192020;

import java.io.IOException ;
import java.net.ServerSocket ;
import java.net.Socket ;

public class ServerThread implements Runnable {
    @Override
    public void run(){
        try {
            ServerSocket ss = new ServerSocket(12345);
            System.out.println("Server : Serveur lancé");

            while(true){
                Socket s = ss.accept();
                HandleClient hc = new HandleClient(s) ;
                hc.start();
                HandleGame.addClient(hc);
                System.out.println(" Server : Reception d'un client");

            }
        } catch (IOException e){
            System.out.println((e.getMessage()));
            System.out.println("Server Bad");
        }
    }
}
