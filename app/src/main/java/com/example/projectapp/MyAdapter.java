package com.example.projectapp;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Bonsai> items;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    MyAdapter(Context context, List<Bonsai> items, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("violeta-bi", String.valueOf(position));
        holder.title.setText(items.get(position).getName());
        holder.category.setText(items.get(position).getCategory());
       // holder.size.setText(items.get(position).getSize());
        holder.image.setImageResource(Integer.parseInt(items.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addData(ArrayList<Bonsai> listOfBonsai) {
        this.items=listOfBonsai;
        Log.d("violeta", "Adapter "+String.valueOf(items.size()));
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView category;

        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            Log.d("violeta-vh", "VH created");
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            image = itemView.findViewById(R.id.image);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(items.get(getAdapterPosition()));
        }
    }

    public void addData(List<Bonsai> newdata){
        this.items=newdata;//newly added
    }
    public interface OnClickListener {
        void onClick(Bonsai item);
    }
}