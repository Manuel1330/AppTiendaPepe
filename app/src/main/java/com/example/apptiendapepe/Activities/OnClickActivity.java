package com.example.apptiendapepe.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.apptiendapepe.Datos.Usuarios;
import com.example.apptiendapepe.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class OnClickActivity extends Activity {

    TextView txtPersonName, txtPersonGivenName, txtPersonFamilyName, txtPersonEmail, txtPersonId, txtPersonNombreUsuario, txtPersonLugarEntrega,
            txtPersonTelefono, txtPersonObservaciones, txtPersonFechaNacimiento, txtPersonAux1, txtPersonAux2;
    EditText etPersonUltimoPedido, etPersonSaldo;
    ImageView ivPersonPhoto;
    Button btnActualizar;
    String foto;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onclick_normal_activity);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        txtPersonName = findViewById(R.id.txtPersonName);
        txtPersonGivenName = findViewById(R.id.txtPersonGivenName);
        txtPersonFamilyName = findViewById(R.id.txtPersonFamilyName);
        txtPersonEmail = findViewById(R.id.txtPersonEmail);
        txtPersonId = findViewById(R.id.txtPersonId);
        txtPersonNombreUsuario = findViewById(R.id.txtPersonNombreUsuario);
        txtPersonLugarEntrega = findViewById(R.id.txtPersonLugarEntrega);
        txtPersonTelefono = findViewById(R.id.txtPersonTelefono);
        txtPersonObservaciones = findViewById(R.id.txtPersonObservaciones);
        txtPersonFechaNacimiento = findViewById(R.id.txtPersonFechaNacimiento);
        txtPersonAux1 = findViewById(R.id.txtPersonAux1);
        txtPersonAux2 = findViewById(R.id.txtPersonAux2);

        etPersonUltimoPedido = findViewById(R.id.etPersonUltimoPedido);
        etPersonSaldo = findViewById(R.id.etPersonSaldo);

        ivPersonPhoto = findViewById(R.id.ivPersonPhoto);

        btnActualizar = findViewById(R.id.btnActualizar);

        setTextUsuario();

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarUsuario();
            }
        });
    }

    public void setTextUsuario() {

        Bundle objeto = getIntent().getExtras();
        Usuarios user = null;
        if (objeto != null) {
            user = (Usuarios) objeto.getSerializable("user");
        }

        txtPersonName.setText(user.getPersonName());
        txtPersonGivenName.setText(user.getPersonGivenName());
        txtPersonFamilyName.setText(user.getPersonFamilyName());
        txtPersonEmail.setText(user.getPersonEmail());
        txtPersonId.setText(user.getPersonId());
        foto = user.getPersonPhoto();
        Glide.with(this).load(user.getPersonPhoto()).centerCrop().into(ivPersonPhoto);

        txtPersonNombreUsuario.setText(user.getPersonNombreUsuario());
        txtPersonLugarEntrega.setText(user.getPersonLugarEntrega());
        txtPersonTelefono.setText(user.getPersonTelefono());
        txtPersonObservaciones.setText(user.getPersonObservaciones());
        txtPersonFechaNacimiento.setText(user.getPersonFechaNacimiento());
        txtPersonAux1.setText(user.getPersonAux1());
        txtPersonAux2.setText(user.getPersonAux2().toString());

        etPersonUltimoPedido.setText(user.getPersonUltimoPedido());
        etPersonSaldo.setText(user.getPersonSaldo().toString());

    }

    public void editarUsuario(){
        Usuarios usuario = new Usuarios(
                txtPersonName.getText().toString(),
                txtPersonGivenName.getText().toString(),
                txtPersonFamilyName.getText().toString(),
                txtPersonEmail.getText().toString(),
                txtPersonId.getText().toString(),
                foto,
                txtPersonNombreUsuario.getText().toString(),
                txtPersonLugarEntrega.getText().toString(),
                txtPersonTelefono.getText().toString(),
                txtPersonObservaciones.getText().toString(),
                txtPersonFechaNacimiento.getText().toString(),
                txtPersonAux1.getText().toString(),
                Double.parseDouble(txtPersonAux2.getText().toString()),
                etPersonUltimoPedido.getText().toString(),
                Double.parseDouble(etPersonSaldo.getText().toString()),
                "false"
        );


        databaseReference.child("usuario").child(usuario.getPersonId()).setValue(usuario,
                new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(OnClickActivity.this, "Usuario... Actualizado", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
