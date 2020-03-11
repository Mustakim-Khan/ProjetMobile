package com.example.projetserver;

import androidx.appcompat.app.AppCompatActivity;

import java.net.Socket;

public class HandleClient extends AppCompatActivity implements  Runnable{
    private Socket s ;
    public HandleClient(Socket s) {
        this.s = s ;
    }
    @Override
    public void run (){
        System.out.println("Je suis dans le handle client");
    }
}
