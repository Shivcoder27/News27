package com.example.news27;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder  extends RecyclerView.ViewHolder {
   TextView text_title,text_Source;
   ImageView img_Headline;
   CardView cardView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        text_title = itemView.findViewById(R.id.text_headline);
        text_Source =  itemView.findViewById(R.id.text_source);
        img_Headline = itemView.findViewById(R.id.img_headline);
        cardView=itemView.findViewById(R.id.main_container);

    }
}
