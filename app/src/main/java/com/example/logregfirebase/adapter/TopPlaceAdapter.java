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
import com.example.logregfirebase.model.TopPlaceData;

import java.util.List;

public class TopPlaceAdapter extends RecyclerView.Adapter<TopPlaceAdapter.TopPlaceViewHolder> {
    Context context;
    List<TopPlaceData> topPlaceDataList;

    public TopPlaceAdapter(Context context, List<TopPlaceData> topPlaceDataList) {
        this.context = context;
        this.topPlaceDataList = topPlaceDataList;
    }

    @NonNull
    @Override
    public TopPlaceViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_place_row_item, parent, false);
        return new TopPlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopPlaceViewHolder holder, int position) {
        holder.placeName.setText((topPlaceDataList.get(position).getPlaceName()));
        holder.countryName.setText((topPlaceDataList.get(position).getCountryName()));
        holder.price.setText((topPlaceDataList.get(position).getPrice()));
        holder.placeImage.setImageResource((topPlaceDataList.get(position).getImageUrl()));

        String nama = topPlaceDataList.get(position).getPlaceName();
        String namaDaerah = topPlaceDataList.get(position).getCountryName();
        String harga = topPlaceDataList.get(position).getPrice();
        int gambar = topPlaceDataList.get(position).getGambarBesar();

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
        return topPlaceDataList.size();
    }

    public static final class TopPlaceViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, countryName, price;

        public TopPlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image_history);
            placeName = itemView.findViewById(R.id.place_name_history);
            countryName = itemView.findViewById(R.id.country_name_history);
            price = itemView.findViewById(R.id.price_history);

        }
    }
}
