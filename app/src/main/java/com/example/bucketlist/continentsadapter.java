package com.example.bucketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class continentsadapter extends RecyclerView.Adapter<continentsadapter.ViewHolder> {
int images[];
    public continentsadapter(int[] africa) {
        this.images = africa;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.singleitem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(continentsadapter.ViewHolder holder, int position) {
      int img=images[position];
      holder.img.setImageResource(img);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.singleimg);
        }
    }

}
