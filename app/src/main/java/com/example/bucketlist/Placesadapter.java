package com.example.bucketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class Placesadapter extends RecyclerView.Adapter<Placesadapter.ViewHolder> {
    int[] data;
    private onItemClickListener monItemClickListener;

    public interface onItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener monItemClickListener){
        this.monItemClickListener=monItemClickListener;
    }

    public Placesadapter(int[] data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.categoriesitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Placesadapter.ViewHolder holder, int position) {
        int img = data[position];
        holder.img.setImageResource(img);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.categoriesitem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(monItemClickListener!= null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            monItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
