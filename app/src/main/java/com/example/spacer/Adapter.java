package com.example.spacer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<String> nums;
    LayoutInflater inflater;
    

    public Adapter(Context cxt,List<String> nums){
        this.nums=nums;
        this.inflater=LayoutInflater.from(cxt);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.num.setText(nums.get(position));
        if (position % 2 == 0)
        {
            holder.cardView.setCardBackgroundColor(Color.RED);
        } else
        {
            holder.cardView.setCardBackgroundColor(Color.BLUE);
        }
    }

    @Override
    public int getItemCount() {
        return nums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView num;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            num=itemView.findViewById(R.id.textView1);
            cardView=itemView.findViewById(R.id.carrd);
        }
    }
}
