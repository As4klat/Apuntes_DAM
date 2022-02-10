package Clases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeria.R;

import java.util.List;

public class PizzasPreAdapter extends RecyclerView.Adapter<PizzasPreAdapter.ViewHolder> {
    private List<Pizza> mDataSet;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombrePizza;
        TextView ingedientesPizza;

        ViewHolder(View v) {
            super(v);
            nombrePizza = v.findViewById(R.id.nombrePizza);
            ingedientesPizza = v.findViewById(R.id.ingredientesPizza);
        }
    }

    public PizzasPreAdapter(List<Pizza> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pizza, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = mDataSet.get(position).getNombre();
        String ingredientes = mDataSet.get(position).ingredientesToString();

        holder.nombrePizza.setText(nombre);
        holder.ingedientesPizza.setText(ingredientes);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
