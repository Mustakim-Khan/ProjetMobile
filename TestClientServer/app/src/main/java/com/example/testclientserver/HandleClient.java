package com.example.testclientserver;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HandleClient {

    private Socket s ;

    public HandleClient(Socket s ){
         this.s = s ;
         try {
             InputStream is = s.getInputStream();
         } catch (IOException e ){
             System.out.println(e.getMessage());
         }
         System.out.println("salut a tous");
    }

}
