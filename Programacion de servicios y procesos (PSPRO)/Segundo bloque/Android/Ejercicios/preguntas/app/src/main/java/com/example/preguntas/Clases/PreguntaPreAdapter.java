package com.example.preguntas.Clases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.preguntas.R;

import java.util.List;

public class PreguntaPreAdapter extends RecyclerView.Adapter<PreguntaPreAdapter.ViewHolder>{
    private List<Pregunta> mDataSet;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_pregunta;

        ViewHolder(View v) {
            super(v);
            item_pregunta = v.findViewById(R.id.item_pregunta);
        }
    }

    public PreguntaPreAdapter(List<Pregunta> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pregunta, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = mDataSet.get(position).getPregunta();
        holder.item_pregunta.setText(nombre);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
