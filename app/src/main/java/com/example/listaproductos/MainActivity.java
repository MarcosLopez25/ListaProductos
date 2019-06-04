package com.example.listaproductos;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.example.listaproductos.Adaptador.pos;

public class MainActivity extends AppCompatActivity {

    public static EditText txtname;
    public static EditText txtPrecio;

    public static RecyclerView recycler;

    public static ArrayList<Producto>listaProductos = new ArrayList<>();
    public static   Adaptador adapter = new Adaptador(listaProductos);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FloatingActionButton fbAgregar = (FloatingActionButton) findViewById(R.id.fbAdd);
        final FloatingActionButton fbTotal = (FloatingActionButton) findViewById(R.id.fbPay);
        txtname = findViewById(R.id.txtName);
        txtPrecio = findViewById(R.id.txtPrecio);
        recycler = findViewById(R.id.rvLista);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        recycler.setAdapter(adapter);
        fbAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Formulario.class);
                startActivity(intent);
            }
        });


        fbTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                new AlertDialog.Builder(MainActivity.this,R.style.CustomDialogTheme)
                        .setTitle("Desea confirmar su compra?")
                        .setMessage("Total de productos adquiridos son: "+listaProductos.size()+"\nTotal a pagar: $"+ totalPago())
                        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Compra realizada", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("MainActivity", "Aborting mission...");
                            }
                        })
                        .show();
            }
        });
    }
    public int totalPago(){
        String result = "";
        int total = 0;
        for (int i=0; i<listaProductos.size();i++){
            result = listaProductos.get(i).getPrecioProduct();
            total = total + Integer.parseInt(result);
        }
        return total ;
    }
}


