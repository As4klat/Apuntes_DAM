package com.example.examen_android_gamaza;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PalabrasPreAdapter extends RecyclerView.Adapter<PalabrasPreAdapter.ViewHolder>{
    private List<Palabra> mDataSet;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView palabra_espanolview;
        TextView palabra_inglesview;

        ViewHolder(View v) {
            super(v);
            palabra_espanolview = v.findViewById(R.id.palabra_espanolview);
            palabra_inglesview = v.findViewById(R.id.palabra_inglesview);
        }
    }

    public PalabrasPreAdapter(List<Palabra> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_palabra, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String palabra_espanol = mDataSet.get(position).getPalabra_espanol();
        String palabra_ingles = mDataSet.get(position).getPalabra_ingles();

        holder.palabra_espanolview.setText(palabra_espanol);
        holder.palabra_inglesview.setText(palabra_ingles);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
