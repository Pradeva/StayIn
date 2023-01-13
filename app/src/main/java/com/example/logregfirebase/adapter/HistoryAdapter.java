package com.example.logregfirebase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logregfirebase.R;
import com.example.logregfirebase.model.HistoryData;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    Context context;
    List<HistoryData> historyDataList;

    public HistoryAdapter(Context context, List<HistoryData> historyDataList) {
        this.context = context;
        this.historyDataList = historyDataList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_row_item,parent,false);
        return new HistoryViewHolder(view);

    }

    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryViewHolder holder, int position) {
        holder.placeName.setText((historyDataList.get(position).getPlaceName()));
        holder.countryName.setText((historyDataList.get(position).getCountryName()));
        holder.price.setText((historyDataList.get(position).getPrice()));
        holder.placeImage.setImageResource((historyDataList.get(position).getGambarBesar()));

    }

    public int getItemCount(){
        return historyDataList.size();
    }

    public static final class HistoryViewHolder extends RecyclerView.ViewHolder{
        ImageView placeImage;
        TextView placeName, countryName, price;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image_history);
            placeName = itemView.findViewById(R.id.place_name_history);
            countryName = itemView.findViewById(R.id.country_name_history);
            price = itemView.findViewById(R.id.price_history);

        }
    }
}
