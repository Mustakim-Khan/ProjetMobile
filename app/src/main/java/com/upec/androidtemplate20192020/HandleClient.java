package com.upec.androidtemplate20192020;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HandleClient extends Thread {

    private Socket s ;
    private ObjectInputStream ois ;
    private ObjectOutputStream oos ;


    public HandleClient(Socket s) {
        this.s = s ;
    }

    @Override
    public void run() {
        try {
            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
            while (true){
                execute();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private synchronized void execute() {
        try {
            System.out.println("Serveur : en attente d'un nombre");
            int a = ois.readInt();
            switch (a){
                case 0 :
                    System.out.println("Serveur : a recu 0");
                    receivePoint();
                    break;
                case 1 :
                    System.out.println("Serveur : a recu 1");
                    sendPoint();
                    break;
            }
        } catch (IOException e){}
    }

    private synchronized void receivePoint(){
        try {
            //oos.writeInt(0);
            //oos.flush();
            System.out.println("Serveur : en attente d'un point");
            Point p = (Point) ois.readObject();
            HandleGame.addPoint(p);
            System.out.println("Serveur : point ajouté au jeu");
            for (HandleClient hc : HandleGame.getClient()){
                hc.getOos().writeInt(0);
                hc.getOos().writeObject(p);
                hc.getOos().flush();
            }
            System.out.println("Serveur : renvoie le point");
        } catch (IOException | ClassNotFoundException e ){}
    }

    private synchronized void sendPoint (){
        try {
            oos.writeInt(1);
            oos.writeObject(HandleGame.getPoints());
            oos.flush();
        } catch (IOException e){}
    }

    public ObjectOutputStream getOos() {
        return oos;
    }
}
