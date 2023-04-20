package com.example.applabsrbethancourt_ppalacios_dfabbroni.Helpers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class CustomDialog extends DialogFragment {

    private String mensaje,titulo;

    public CustomDialog(String t,String m){
        this.mensaje = m;
        this.titulo = t;
    }

    @Override
    public Dialog onCreateDialog(Bundle b){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(mensaje)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setTitle(titulo);

        return builder.create();
    }
}
