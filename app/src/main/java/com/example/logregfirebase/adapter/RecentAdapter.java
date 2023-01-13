package com.example.logregfirebase.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logregfirebase.DetailsActivity;
import com.example.logregfirebase.R;
import com.example.logregfirebase.model.RecentData;

import java.util.List;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.RecentViewHolder> {
    Context context;
    List<RecentData> recentDataList;

    public RecentAdapter(Context context, List<RecentData> recentDataList) {
        this.context = context;
        this.recentDataList = recentDataList;
    }

    @NonNull
    @Override
    public RecentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recent_row_item, parent, false);
        return new RecentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentViewHolder holder, int position) {
        holder.placeName.setText((recentDataList.get(position).getPlaceName()));
        holder.countryName.setText((recentDataList.get(position).getCountryName()));
        holder.price.setText((recentDataList.get(position).getPrice()));
        holder.placeImage.setImageResource((recentDataList.get(position).getImageUrl()));

        String nama = recentDataList.get(position).getPlaceName();
        String namaDaerah = recentDataList.get(position).getCountryName();
        String harga = recentDataList.get(position).getPrice();
        int gambar = recentDataList.get(position).getGambarBesar();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailsActivity.class);
                i.putExtra("namaData",nama);
                i.putExtra("namaDaerahData", namaDaerah);
                i.putExtra("hargaData", harga);
                i.putExtra("gambarData", gambar);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recentDataList.size();
    }

    public static final class RecentViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, countryName, price;

        public RecentViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image_history);
            placeName = itemView.findViewById(R.id.place_name_history);
            countryName = itemView.findViewById(R.id.country_name_history);
            price = itemView.findViewById(R.id.price_history);

        }
    }
}
