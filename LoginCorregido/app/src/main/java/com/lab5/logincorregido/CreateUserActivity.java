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

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;

public class CreateUserActivity extends AppCompatActivity {

    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        this.InicializarControles();
    }

    private void InicializarControles(){
        user = (EditText)findViewById(R.id.lblcreateEmailInput);
        pass = (EditText)findViewById(R.id.lblcreatePassInput);
    }

    public void InsertarUsuario(View v){
        try {
            String u = user.getText().toString();
            String p = pass.getText().toString();
            GuardarArchivo(u, p);
            startActivity(new Intent(getApplicationContext(), MainLoginActivity.class));
        }catch (Exception e){

        }
    }

    //MODO PRIVADO

    /*
    private void GuardarArchivo(String u, String p) {
        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(openFileOutput("login.txt", Context.MODE_PRIVATE));
            writer.write(u+"~"+p);
            writer.close();
            Toast.makeText(getApplicationContext(), "Guardado", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

    //MODO APPEND
    //MODO_APPEND para acceder al archivo como un apendi
    // "\n" se coloca en la insercion para que el registro se coloque en una nueva linea y permitir la lectura como otro usuario
    private void GuardarArchivo(String u, String p) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(openFileOutput("login.txt", Context.MODE_APPEND));
            writer.write("\n" + u + "~" + p);
            writer.close();
            Toast.makeText(getApplicationContext(), "Guardado", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}