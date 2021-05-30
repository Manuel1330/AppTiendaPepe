package com.example.apptiendapepe.Adaptadores;

import android.content.Context;
        import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apptiendapepe.Activities.OnClickActivity;
import com.example.apptiendapepe.Activities.OnLongClickActivity;
import com.example.apptiendapepe.Datos.Usuarios;
import com.example.apptiendapepe.R;

import java.util.ArrayList;

public class AdapterUsuarios extends RecyclerView.Adapter<AdapterUsuarios.ViewHolderUsuarios> implements View.OnClickListener{

    ArrayList<Usuarios> listaUsuarios;
    private Context contexto;
    private View.OnClickListener listener;
    private boolean clickLargo = false;

    public AdapterUsuarios(ArrayList<Usuarios> listaUsuarios, Context contexto) {
        this.listaUsuarios = listaUsuarios;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public AdapterUsuarios.ViewHolderUsuarios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_usuarios, null, false);

        view.setOnClickListener(this);

        return new ViewHolderUsuarios(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUsuarios.ViewHolderUsuarios holder, int position) {
        Usuarios usu = listaUsuarios.get(position);

        holder.txtNombre.setText(usu.getPersonName());
        holder.txtId.setText(usu.getPersonId());
        Glide.with(contexto).load(usu.getPersonPhoto()).centerCrop().into(holder.foto);

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clickLargo){
                    Intent intent = new Intent(contexto, OnClickActivity.class);
                    intent.putExtra("personId",usu.getPersonId());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", usu);
                    intent.putExtras(bundle);
                    contexto.startActivity(intent);
                }else {
                    clickLargo = false;
                }
            }
        });

        holder.item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clickLargo = true;
                Intent intent = new Intent(contexto, OnLongClickActivity.class);
                intent.putExtra("personId",usu.getPersonId());
                contexto.startActivity(intent);
                return false;
            }
        });

        if (usu.getBloqueado().equals("true")){
            holder.item.setBackgroundColor(Color.RED);
        }else{
            holder.item.setBackgroundColor(Color.WHITE);
        }

    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolderUsuarios extends RecyclerView.ViewHolder{

        TextView txtNombre, txtId;
        ImageView foto;
        LinearLayout item;


        public ViewHolderUsuarios(@NonNull View itemView) {
            super(itemView);

            txtNombre= itemView.findViewById(R.id.idNombre);
            txtId= itemView.findViewById(R.id.idId);
            foto= itemView.findViewById(R.id.idImagen);
            item = itemView.findViewById(R.id.idItem);
        }

    }
}