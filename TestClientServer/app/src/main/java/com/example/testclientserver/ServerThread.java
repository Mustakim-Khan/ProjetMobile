package com.example.testclientserver;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
    @Override
    public void run(){
        try {
            ServerSocket ss = new ServerSocket(12345);
            System.out.println("Serveur lancé");
            while(true){
                Socket s = ss.accept();
                System.out.println("Réception d'un client");
                HandleGame.addClient(new HandleClient(s));
            }
        } catch (IOException e){
            System.out.println((e.getMessage()));
            System.out.println("Server Bad");
        }
    }
}
