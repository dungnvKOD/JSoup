package com.dung.jsoup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HoloscropAdapter extends RecyclerView.Adapter<HoloscropAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Holoscop> holoscops;

    public HoloscropAdapter(Context context) {
        this.context = context;
        this.holoscops = new ArrayList<>();//lan chay dau tien no bang rong
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_holoscop, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Holoscop holoscop = holoscops.get(position);
        Glide.with(context).load(holoscop.getAvatar()).into(holder.imgView);
        holder.txtTitle.setText(holoscop.getTitle());

    }

    @Override
    public int getItemCount() {
        return holoscops.size();
    }

    public void setHoloscops(List<Holoscop> holoscops) {
        this.holoscops = holoscops;
        notifyDataSetChanged();//notifi de ve lai ui
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.profile_image);
            txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }
}
