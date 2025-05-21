package com.tom.mathproject_tom_m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

     public class AdapterCard extends RecyclerView.Adapter<AdapterCard.MyViewHolder> {

public interface OnItemClickListener1 {
    void onItemClick(Card item);
}

         public ArrayList<Card> getCards() {
             return cards;
         }

         public void setCards(ArrayList<Card> cards) {
             this.cards = cards;
         }

         public OnItemClickListener1 getListener() {
             return listener;
         }

         public void setListener(OnItemClickListener1 listener) {
             this.listener = listener;
         }

         private ArrayList<Card>cards;
private OnItemClickListener1 listener;

public AdapterCard (ArrayList<Card>cards, OnItemClickListener1
listener) {
        this.cards = cards;
this.listener = listener;
}
//
@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup
                                               parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.carditem, parent, false);
    return new MyViewHolder(view);
}

// Replace the contents of a view (invoked by the layout manager)
@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int
        position) {
    holder.bind(cards.get(position), listener);
}
// Return the size of your dataset (invoked by the layout manager)
@Override
public int getItemCount() {
    return cards.size();
}
/**
 * Provide a reference to the type of views that you are using
 * (custom ViewHolder).
 */
public static class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView ivcardImg;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        ivcardImg = itemView.findViewById(R.id.imgcard);
    }
    public void bind(final Card item, final OnItemClickListener1 listener) {
        ivcardImg.setImageResource(item.getImage());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }
}
public void updateArr(ArrayList<Card>cards2){
    cards=cards2;
}
}//end class



