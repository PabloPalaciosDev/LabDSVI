package com.lab5.logincorregido;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainLoginActivity extends AppCompatActivity {

    EditText user, pass;
    private static boolean ejecucion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.InicializarControles();
        this.CargarInicial();
    }

    private void InicializarControles() {
        user = (EditText) findViewById(R.id.lblEmailInput);
        pass = (EditText) findViewById(R.id.lblPassInput);
    }

    private synchronized void CargarInicial() {

        if(ejecucion){
            try {
                OutputStreamWriter writer = new OutputStreamWriter(openFileOutput("login.txt", Context.MODE_PRIVATE));
                writer.write("pablo" + "~" + "12345");
                writer.close();

            } catch (Exception e) {

            }
            ejecucion = false;
        }
        else {
            Toast.makeText(getApplicationContext(), "USUARIOS CARGADOS", Toast.LENGTH_LONG).show();
        }
    }

    public void ValidarUsuario(View v) {
        try {
                SessionPorArchivo();
        } catch (Exception e) {

        }
    }

    /*
    private void SessionPorArchivo() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("login.txt")));
            String[] credenciales = bf.readLine().split("~");
            bf.close();
            if (user.getText().toString().equals(credenciales[0]) && pass.getText().toString().equals(credenciales[1])) {
                Toast.makeText(getApplicationContext(), "BIENVENIDX", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));

            }
        } catch (Exception e) {

        }
    }
*/

    //Recorremos todos los registros del login.txt

    private void SessionPorArchivo() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("login.txt")));
            String line;
            boolean found = false;

            while ((line = bf.readLine()) != null) {
                String[] credenciales = line.split("~");
                if (user.getText().toString().equals(credenciales[0]) && pass.getText().toString().equals(credenciales[1])) {
                    found = true;
                    break;
                }
            }

            bf.close();

            if (found) {
                Toast.makeText(getApplicationContext(), "BIENVENIDX", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
