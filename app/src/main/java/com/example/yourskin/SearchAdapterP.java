package com.example.yourskin;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


class SearchViewHolderP extends RecyclerView.ViewHolder {
    public TextView denumire, brand, tip, ingrediente, rank;

    public SearchViewHolderP(@NonNull View itemView) {
        super(itemView);
        denumire = itemView.findViewById(R.id.denumire);
        brand = itemView.findViewById(R.id.brand);
        tip = itemView.findViewById(R.id.tip);
        ingrediente = itemView.findViewById(R.id.ingrediente);
        rank=itemView.findViewById(R.id.rank);
        //TextView ingrediente = (TextView) rootView.findViewById(R.id.ingrediente.message_scroll);
        //ingrediente.setMovementMethod(new ScrollingMovementMethod());
    }
}

public class SearchAdapterP extends RecyclerView.Adapter<SearchViewHolderP> {

    private Context context;
    private List<Produs> produse;

    public SearchAdapterP(Context context, List<Produs> produse){
        this.context=context;
        this.produse=produse;
    }

    @NonNull
    @Override
    public SearchViewHolderP onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item2,parent,false);
        return new SearchViewHolderP(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull SearchViewHolderP holder, int position) {
        holder.tip.setText(produse.get(position).getTip());
        holder.brand.setText(produse.get(position).getBrand());
        holder.denumire.setText(produse.get(position).getDenumire());
        holder.ingrediente.setText(produse.get(position).getIngrediente());
        holder.rank.setText(produse.get(position).getRank());

    }

    @Override
    public int getItemCount() { return produse.size();
    }
}
