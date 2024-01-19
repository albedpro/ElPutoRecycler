package com.mcas2.historiceventsrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoricEventRVAdapter extends RecyclerView.Adapter<HistoricEventRVAdapter.MyViewHolder> {
    Context context;
    ArrayList<divisasEventModel> divisasEventModel;

    public HistoricEventRVAdapter(Context context, ArrayList<divisasEventModel> divisasEventModel) {
        this.context = context;
        this.divisasEventModel = divisasEventModel;
    }

    @NonNull
    @Override
    public HistoricEventRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent, false);
        return new HistoricEventRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricEventRVAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(divisasEventModel.get(position).getDivisaName());
        holder.tvPrecio.setText(divisasEventModel.get(position).getDivisaPrecio());
    }

    @Override
    public int getItemCount() {
        return divisasEventModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrecio;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvEventName);
            tvPrecio = itemView.findViewById(R.id.tvEventPrecio);
        }
    }
}
