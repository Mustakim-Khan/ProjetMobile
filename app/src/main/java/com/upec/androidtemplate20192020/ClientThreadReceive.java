package com.upec.androidtemplate20192020;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThreadReceive extends Thread {

    private Socket s ;
    private ObjectInputStream ois ;
    //private ObjectOutputStream oos ;


    public ClientThreadReceive(Socket s ) {
        this.s = s ;
    }

    @Override
    public void run(){
        try {

            //oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            while (true){
                execute();
            }

        } catch (IOException e){}
    }

    private synchronized void execute(){
        try {
            int a = ois.readInt();
            switch (a){
                case 0 :
                    receivePoint();
                    break ;
                case 1 :
                    receiveList();
                    break;
            }
        } catch (IOException e){}

    }



    private synchronized void receivePoint(){
        try {
            System.out.println("Client Receive : attend un point");
            Point p = (Point) ois.readObject();
            Dessin.addPoint(p);
            System.out.println("Client Receive : point ajouté au dessin");
        }catch (IOException | ClassNotFoundException e){}
    }

    private synchronized void receiveList(){
        try {
            System.out.println("Client Receive : attend une liste point");
            ArrayList<Point> p = (ArrayList<Point>) ois.readObject();
            Dessin.setPoints(p);
        }catch (IOException | ClassNotFoundException e){}
    }


}
