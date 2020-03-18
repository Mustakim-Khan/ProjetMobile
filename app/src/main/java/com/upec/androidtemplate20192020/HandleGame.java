package com.upec.androidtemplate20192020;


import java.util.ArrayList;

public class HandleGame {
    private static ArrayList<HandleClient> client = new ArrayList<>() ;
    private static  ArrayList<Point> points = new ArrayList<>() ;

    public static void addClient (HandleClient c) {
        client.add(c);
    }

    public static void removeClient(HandleClient c) {
        client.remove(c);
    }

    public static HandleClient getClient (int i){
        return client.get(i);
    }

    public static int sizeClient(){
        return client.size();
    }

    public static ArrayList<Point> getPoints() {
        return points;
    }

    public static void addPoint (Point p){
        points.add(p);
    }

}