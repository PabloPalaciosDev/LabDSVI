package com.example.applabsrbethancourt_ppalacios_dfabbroni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applabsrbethancourt_ppalacios_dfabbroni.Helpers.CustomDialog;

public class MainActivity extends AppCompatActivity {

    //declaramos las variables de los controles que vamos a utilizar
    EditText txtNum1;
    EditText txtNum2;

    CheckBox chkMensaje;
    Spinner spnOperador;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControles();
        this.InicializarSpinner();
    }

    private void InicializarControles() {
        txtNum1 = (EditText)findViewById(R.id.txtNum1);
        txtNum2 = (EditText)findViewById(R.id.txtNum2);

        chkMensaje = (CheckBox)findViewById(R.id.chkDialog);

        spnOperador = (Spinner)findViewById(R.id.spnOperador);

        lblResultado = (TextView)findViewById(R.id.lblRes);
    }

    private void InicializarSpinner() {
        ArrayAdapter<CharSequence> adapterOperadores = ArrayAdapter
                .createFromResource(getApplicationContext(),R.array.operadoresMatematicos,android.R.layout.simple_spinner_dropdown_item);

        spnOperador.setAdapter(adapterOperadores);
    }

    private String ObtenerOperacionSeleccionado(){
        try {
            return (String)spnOperador.getSelectedItem();
        }catch (Exception e){

        }
        return "";
    }

    private double SumarNumeros(double n1, double n2)
    {
        return n1+n2;
    }

    private double RestarNumeros(double n1, double n2) { return n1-n2; }

    private double MultiplicarNumeros(double n1, double n2) { return n1*n2; }

    private double DividirNumeros(double n1, double n2) { return n1/n2; }

    public void calcularNumeros(View view)
    {
        try{
            double n1 = Integer.parseInt(txtNum1.getText().toString());
            double n2 = Integer.parseInt(txtNum2.getText().toString());
            String operador = this.ObtenerOperacionSeleccionado();
            double resultado = 0;

            switch(operador) {
                case "Sumar":
                    resultado = this.SumarNumeros(n1, n2);
                    break;
                case "Restar":
                    resultado = this.RestarNumeros(n1, n2);
                    break;
                case "Multiplicar":
                    resultado = this.MultiplicarNumeros(n1, n2);
                    break;
                case "Dividir":
                    resultado = this.DividirNumeros(n1, n2);
                    break;
                default:
                    Toast.makeText(this,"Error: debe seleccionar un operador", Toast.LENGTH_SHORT).show();
            }

            if (chkMensaje.isChecked()) {
                FragmentManager fm = getSupportFragmentManager();
                CustomDialog dialog = new CustomDialog("El resultado es: ", "\n"+resultado);
                dialog.show(fm,"DIALOG");
                lblResultado.setText("");
            } else {
                lblResultado.setText(Double.toString(resultado));
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this,"Error en el calculo de los datos" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
