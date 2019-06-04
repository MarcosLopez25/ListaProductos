package com.example.listaproductos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class Formulario extends AppCompatActivity {

    Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Button btnAdd = (Button) findViewById(R.id.btnAgregar);
        final TextInputEditText txtNombre = findViewById(R.id.txtName);
        final TextInputEditText txtPrecio = findViewById(R.id.txtPrecio);
        final TextInputEditText txtFecha = findViewById(R.id.txtFecha);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtNombre.getText().toString();
                String precio = txtPrecio.getText().toString();
                String fecha = txtFecha.getText().toString();

                MainActivity.listaProductos.add(new Producto(name,precio,fecha,"En proceso..."));
                MainActivity.recycler.setAdapter(MainActivity.adapter);

                Intent menu = new Intent(Formulario.this, MainActivity.class);

                startActivity(menu);

            }
        });
    }
}
