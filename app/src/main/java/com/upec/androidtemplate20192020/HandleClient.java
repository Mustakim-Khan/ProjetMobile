package com.upec.androidtemplate20192020;

import android.util.Log;

import com.upec.androidtemplate20192020.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class HandleClient {

    private Socket s ;
    private ObjectInputStream ois ;
    private ObjectOutputStream oos ;

    public HandleClient(Socket s ){
        this.s = s ;
    }

}
