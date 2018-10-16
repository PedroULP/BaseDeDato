package com.example.pedro.github;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pedro.github.Aplicattion.BaseAplication;

import java.security.Principal;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText telefono;
    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre= (EditText)findViewById(R.id.etnombre);
        apellido= (EditText)findViewById(R.id.etapellido);
        telefono= (EditText)findViewById(R.id.ettelefono);

        guardar= (Button)findViewById(R.id.btguardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ((BaseAplication)getApplication()).insertarCliente(nombre.getText().toString(),apellido.getText().toString(),telefono.getText().toString());
                Intent in= new Intent(MainActivity.this, ListActivity.class);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        if(id == R.id.action_settings)
            return true;

        return super.onOptionsItemSelected(item);
    }
}
