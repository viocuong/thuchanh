package com.example.thuchanh;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thuchanh.model.ThaThinh;

import java.util.List;

public class ThathinhAdapter extends RecyclerView.Adapter<ThathinhAdapter.ThathinhViewholder> {
    private Activity activity;
    private List<ThaThinh> list;
    public ThathinhAdapter(Activity activity, List<ThaThinh> list){
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ThathinhViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = activity.getLayoutInflater().inflate(R.layout.item,parent,false);
        return new ThathinhViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ThathinhViewholder holder, int position) {
        ThaThinh t = list.get(position);
        holder.img.setImageResource(t.getRsImg());
        holder.name.setText(t.getName());
        holder.time.setText(t.getTime());
        holder.rating.setRating(t.getRating());
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ThathinhViewholder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name,time;
        private RatingBar rating;
        private Button btnRemove;
        public ThathinhViewholder(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.img);
            name = v.findViewById(R.id.name);
            time = v.findViewById(R.id.time);
            rating = v.findViewById(R.id.rating);
            btnRemove = v.findViewById(R.id.btnRemove);
        }
    }
}
