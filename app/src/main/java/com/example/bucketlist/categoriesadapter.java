package com.example.bucketlist;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class categoriesadapter extends RecyclerView.Adapter<categoriesadapter.ViewHolder> {
    private onItemCLickListener monItemListener;
    public interface onItemCLickListener{
        void onitemclick(int position);
    }
    public void setOnItemClickListerner(onItemCLickListener monItemCLickinterface){
        this.monItemListener=monItemCLickinterface;
    }
    int[] data;
    public categoriesadapter(int[] data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.categoriesitem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(categoriesadapter.ViewHolder holder, int position) {
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
                    int position= getAdapterPosition();
                    monItemListener.onitemclick(position);
                }
            });

        }
    }
}
