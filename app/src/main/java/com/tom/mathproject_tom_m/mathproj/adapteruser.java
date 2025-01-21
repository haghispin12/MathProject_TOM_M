package com.tom.mathproject_tom_m.mathproj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tom.mathproject_tom_m.R;

import java.util.ArrayList;

public class adapteruser extends RecyclerView.Adapter<adapteruser.MyViewHolder>{
    public interface OnItemClickListener1 {
        void onItemClick(User item);
    }

    private  ArrayList<User> Myusers;;
    private OnItemClickListener1 listener;

    public adapteruser(  ArrayList<User> Myusers, OnItemClickListener1 listener) {
        this.Myusers=Myusers;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemuser123, parent, false);
        return  new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(Myusers.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return Myusers.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvuserName ;
      TextView tvgrade;
        ImageView ivuserImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvuserName = itemView.findViewById(R.id.UserName);
            ivuserImg = itemView.findViewById(R.id.imageuser);
          tvgrade=itemView.findViewById(R.id.grade);
        }

        public void bind(final User item, final OnItemClickListener1 listener)      {
            tvuserName.setText(item.getName());
            ivuserImg.setImageBitmap(item.getBitmap());
        tvgrade.setText(item.getScore()+"");
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

    }
}



