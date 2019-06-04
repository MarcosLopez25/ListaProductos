package com.example.listaproductos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderDatos> {

    Context context;
    ArrayList<Producto> listProduct;
    AlertDialog dialog;
    public static int pos = 0;

    public Adaptador(ArrayList<Producto> listProduct)
    {
        this.listProduct = listProduct;
    }

    public static class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nombre, precio, fecha, status;
        ImageButton edit, delete, lock;

        public ViewHolderDatos(@NonNull View v) {
            super(v);
            nombre = v.findViewById(R.id.txtView);
            precio = v.findViewById(R.id.txtPrecio);
            fecha = v.findViewById(R.id.txtFecha);
            status = v.findViewById(R.id.txtStatus);
            edit = v.findViewById(R.id.btnEdit);
            delete = v.findViewById(R.id.btnDelete);
            lock = v.findViewById(R.id.btnBlock);
        }
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler,null,false);
        ViewHolderDatos vh = new ViewHolderDatos(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderDatos viewHolderDatos, final int i) {

        viewHolderDatos.nombre.setText(listProduct.get(i).getNombreProduct());
        viewHolderDatos.precio.setText(listProduct.get(i).getPrecioProduct());
        viewHolderDatos.fecha.setText(listProduct.get(i).getFecha());
        viewHolderDatos.status.setText(listProduct.get(i).getStatusProduct());
        viewHolderDatos.edit.setImageResource(R.drawable.edit);
        viewHolderDatos.delete.setImageResource(R.drawable.delete);
        viewHolderDatos.lock.setImageResource(R.drawable.lock_out);

        viewHolderDatos.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listProduct.remove(i);
                notifyDataSetChanged();
            }
        });

        viewHolderDatos.lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolderDatos.lock.isClickable()){
                    viewHolderDatos.status.setText("Finalizado");
                    viewHolderDatos.lock.setEnabled(false);
                    viewHolderDatos.lock.setImageResource(R.drawable.lock_in);
                    viewHolderDatos.edit.setEnabled(false);
                }
                pos = i;
            }
        });

        viewHolderDatos.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getContext());
                v = LayoutInflater.from(v.getContext()).inflate(R.layout.edit, null, false);
                final EditText nombre = v.findViewById(R.id.edName);
                final EditText precios = v.findViewById(R.id.edPrecio);
                Button btnUpdate = v.findViewById(R.id.btnActualizar);
                pos = i;
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nombreP = nombre.getText().toString();
                        String precioP = precios.getText().toString();
                        listProduct.remove(pos);
                        listProduct.add(pos, new Producto(nombreP, precioP, "03/05/2019", "En proceso..."));

                        notifyDataSetChanged();
                        dialog.dismiss();

                    }

                });
                mBuilder.setView(v);
                dialog = mBuilder.create();
                dialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

}
