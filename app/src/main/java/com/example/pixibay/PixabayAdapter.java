package com.example.pixibay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PixabayAdapter extends RecyclerView.Adapter<PixabayAdapter.HitViewHolder> {
    private Context context;
    private List<Hit> hits;

    public PixabayAdapter(Context context, List<Hit> hits) {
        this.context = context;
        this.hits = hits;
    }

    @Override
    public HitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hit_item, parent, false);;
        return new HitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HitViewHolder holder, int position) {
        Hit hit = hits.get(position);
        Glide.with(context).load(hit.getWebformatURL()).fitCenter().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return hits.size();
    }

    public void addItem(Hit hit){
        hits.add(hit);
        notifyDataSetChanged();
    }

    public void addItems(List<Hit> hits){
        hits.addAll(hits);
        notifyDataSetChanged();
    }

    class HitViewHolder extends RecyclerView.ViewHolder{
        public CardView cv;
        public ImageView image;

        public HitViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }
    }
}