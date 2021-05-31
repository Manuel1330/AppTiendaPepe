package com.example.apptiendapepe.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.apptiendapepe.Datos.Articulos;
import com.example.apptiendapepe.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ArticulosFragment extends Fragment {

    DatabaseReference databaseReference;

    EditText etCodigoArt, etDescripcionArt, etPrecioArt, etStockageArt, etFotoArt;
    Button btnSubirArt;
    
    public ArticulosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_articulos, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etCodigoArt = view.findViewById(R.id.etCodigoArt);
        etDescripcionArt = view.findViewById(R.id.etDescripcionArt);
        etPrecioArt = view.findViewById(R.id.etPrecioArt);
        etStockageArt = view.findViewById(R.id.etStockageArt);
        etFotoArt = view.findViewById(R.id.etFotoArt);

        btnSubirArt = view.findViewById(R.id.btnSubirArt);

        btnSubirArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subirArticulos();
            }
        });

    }


    public void subirArticulos() {
        Articulos articulo = new Articulos(
                etCodigoArt.getText().toString(),
                etDescripcionArt.getText().toString(),
                Double.parseDouble(etPrecioArt.getText().toString()),
                Double.parseDouble(etStockageArt.getText().toString()),
                etFotoArt.getText().toString()
        );

        databaseReference.child("articulo").child(articulo.getCodigoArt()).setValue(articulo,
                new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(getContext(), "Articulo Añadido", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
