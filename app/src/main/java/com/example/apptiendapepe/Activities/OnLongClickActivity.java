package com.example.apptiendapepe.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.apptiendapepe.R;
import com.google.firebase.database.FirebaseDatabase;

public class OnLongClickActivity extends Activity {

    Button btnBloquear, btnDesbloquear;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onclick_long_activity);

        btnBloquear = findViewById(R.id.btnBloquear);
        btnDesbloquear = findViewById(R.id.btnDesbloquear);

        btnBloquear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personId = getIntent().getStringExtra("personId");
                FirebaseDatabase.getInstance().getReference("usuario").child(personId).child("bloqueado").setValue("true")
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(OnLongClickActivity.this, "Se ha bloqueado el usuario", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        btnDesbloquear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personId = getIntent().getStringExtra("personId");
                FirebaseDatabase.getInstance().getReference("usuario").child(personId).child("bloqueado").setValue("false")
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(OnLongClickActivity.this, "Se ha desbloqueado el usuario", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
