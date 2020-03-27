package com.upec.androidtemplate20192020;

import java.util.ArrayList;

public class HandleGame {
    private static ArrayList<HandleClient> client = new ArrayList<>() ;
    private static  ArrayList<Point> points = new ArrayList<>() ;

    public synchronized static void addClient (HandleClient c) {
        client.add(c);
    }

    public synchronized static ArrayList<HandleClient> getClient (){
        return client;
    }

    public static int sizeClient(){
        return client.size();
    }

    public synchronized static ArrayList<Point> getPoints() {
        return points;
    }

    public synchronized static void addPoint (Point p){
        points.add(p);
        //System.out.println(" Serveur nb points : " + points.size());
        //System.out.println("point ajouté");
    }

}
