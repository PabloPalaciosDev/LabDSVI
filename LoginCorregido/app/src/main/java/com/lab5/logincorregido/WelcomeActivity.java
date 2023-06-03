package com.lab5.logincorregido;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void crearUsuario(View v){
        startActivity(new Intent(getApplicationContext(), CreateUserActivity.class));
    }
}
