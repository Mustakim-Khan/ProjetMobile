package com.example.testclientserver;

import java.util.ArrayList;

public class HandleGame {
    private static ArrayList<HandleClient> client = new ArrayList<>() ;

    static void addClient (HandleClient c) {
        client.add(c);
    }

    static void removeClient(HandleClient c) {
        client.remove(c);
    }

    static HandleClient getClient (int i){
        return client.get(i);
    }

    static int sizeClient(){
        return client.size();
    }
}
