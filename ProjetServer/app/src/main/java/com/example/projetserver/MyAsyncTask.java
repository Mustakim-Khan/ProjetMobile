package com.example.projetserver;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... v) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Serveur lancé");
            try {
                Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                int i = 1;

                while (interfaces.hasMoreElements()) {
                    NetworkInterface currentInterface = interfaces.nextElement();
                    //Log.v("Interface "+i," " + currentInterface);
                    i++;
                    Enumeration<InetAddress> addresses = currentInterface.getInetAddresses();
                    int n= 1;
                    while (addresses.hasMoreElements()) {

                        InetAddress currentAddress = addresses.nextElement();
                        System.out.println("IP "+n +" "+ currentAddress.getHostAddress());
                        n++;
                    }
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            while (true){
                System.out.println("J'attends un client");
                Socket s = ss.accept();
                new Thread(new HandleClient(s)).start();
                System.out.println("nouvelle connexion");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

/*
try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Serveur lancé");
            while (true){
                System.out.println("J'attends un client");
                Socket s = ss.accept();
                new Thread(new HandleClient(s)).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
 */
