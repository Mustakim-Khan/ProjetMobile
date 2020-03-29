package com.upec.androidtemplate20192020;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThreadSend extends Thread {

    private Socket s ;
    private String host ;
    private ObjectOutputStream oos ;
    private ArrayList<Point> points = new ArrayList<>();
    private boolean ready = false ;
    private boolean erreurConnexion = false ;


    public ClientThreadSend(String string) {
        host = string ;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(host, 12345);
            this.s = socket;
            ready = true ;
            oos = new ObjectOutputStream(s.getOutputStream());
            init();
            while (true){
                execute();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            ready = true ;
            erreurConnexion = true ;
        }
    }

    private synchronized void execute(){
        if (Dessin.getPointsNonAdd().size() > 0) {
            try {
                oos.writeInt(0);
                oos.writeObject(Dessin.getPointsNonAdd().get(0));
                oos.flush();
                System.out.println("Client Send : envoie 0 et le point");
                Dessin.removePointsNonAdd(0);
            } catch (IOException e) {}
        }
    }

    private synchronized void init(){
        try {
            oos.writeInt(1);
            oos.flush();
        } catch (IOException e){}
    }


    public boolean isReady() {
        return ready;
    }
    public Socket getS() {
        return s;
    }

    public boolean isErreurConnexion() {
        return erreurConnexion;
    }
}
