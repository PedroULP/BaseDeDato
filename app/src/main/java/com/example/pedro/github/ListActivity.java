package com.example.pedro.github;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pedro.github.Aplicattion.BaseAplication;

public class ListActivity extends AppCompatActivity{
    private TextView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lista=(TextView)findViewById(R.id.tvlista);
        for (String it: ((BaseAplication)getApplication()).nombresClientes()){
            lista.setText(lista.getText()+it);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();

        if(id==R.id.action_settings)
            return true;
        return super.onOptionsItemSelected(item);
    }
}
