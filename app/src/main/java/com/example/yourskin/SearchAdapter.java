package com.example.yourskin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


class SearchViewHolder extends RecyclerView.ViewHolder {
    public TextView denumire, tip, descriere;

    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        denumire = itemView.findViewById(R.id.denumire);
        tip = itemView.findViewById(R.id.tip);
        descriere = itemView.findViewById(R.id.descriere);
    }
}

    public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Ingredient> ingrediente;

    public SearchAdapter(Context context, List<Ingredient> ingrediente){
        this.context=context;
        this.ingrediente=ingrediente;
    }

        @NonNull
        @Override
        public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.layout_item,parent,false);
            return new SearchViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
            holder.denumire.setText(ingrediente.get(position).getDenumire());
            holder.tip.setText(ingrediente.get(position).getTip());
            holder.descriere.setText(ingrediente.get(position).getDescriere());

        }

        @Override
        public int getItemCount() {
            return ingrediente.size();
        }
    }
