package com.example.apptiendapepe.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apptiendapepe.Adaptadores.AdapterUsuarios;
import com.example.apptiendapepe.Datos.Usuarios;
import com.example.apptiendapepe.R;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UsuariosFragment extends Fragment{

    ArrayList<Usuarios> listaUsuarios;

    RecyclerView recyclerUsuarios;

    public UsuariosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usuarios, container, false);
        recyclerUsuarios = view.findViewById(R.id.recyclerId);

        listaUsuarios = new ArrayList<>();
        recyclerUsuarios.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarUsuarios();

        AdapterUsuarios adapter = new AdapterUsuarios(listaUsuarios,getContext());

        recyclerUsuarios.setAdapter(adapter);

        return view;
    }

    private void llenarUsuarios() {

        FirebaseDatabase.getInstance().getReference("usuario").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                listaUsuarios.clear();

                task.getResult().getChildren().forEach(child -> {
                    Usuarios usuario = child.getValue(Usuarios.class);
                    if (usuario != null) {
                        listaUsuarios.add(usuario);
                    }
                });

                recyclerUsuarios.getAdapter().notifyDataSetChanged();

            }
        });

    }

}
