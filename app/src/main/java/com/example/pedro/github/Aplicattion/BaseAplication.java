package com.example.pedro.github.Aplicattion;

import android.app.Application;
import android.database.Cursor;

import com.example.pedro.github.Entidades.Cliente;
import com.example.pedro.github.Adapters.DBAdapter;

import java.util.ArrayList;

public class BaseAplication extends Application{

    DBAdapter dbAdapter;

    @Override
    public void onCreate() {
        dbAdapter = new DBAdapter(getApplicationContext());
        dbAdapter.open();

        super.onCreate();
    }

    @Override
    public void onTerminate() {
        dbAdapter.close();
        super.onTerminate();
    }


    public boolean insertarCliente (Cliente cliente){
        return dbAdapter.clienteInsert(cliente.getNombre, cliente.getApellido, cliente.getTelefono);
    }

    public ArrayList<String> nombresClientes () {
        ArrayList<String> lista = new ArrayList<String>();

        Cursor c = dbAdapter.getDatosCliente();
        if (c.moveToFirst()){
            do {
                lista.add(c.getString(1));

            }   while (c.moveToNext());
        }

        return  lista;
    }
}
