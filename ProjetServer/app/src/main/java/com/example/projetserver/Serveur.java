package com.example.projetserver;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serveur);
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
        System.out.println("J'ai accès à la suite");


    }

}
