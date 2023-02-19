package com.example.news27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.news27.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class NewsDetails extends AppCompatActivity {
NewsHeadlines headlines;
TextView txt_title,txt_author,txt_detail,txt_content,txt_time;
ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        txt_title = findViewById(R.id.txt_DTitle);
        txt_author = findViewById(R.id.txt_Dauthor);
        txt_time = findViewById(R.id.txt_Dtime);
        txt_detail = findViewById(R.id.txt_D_detail);
        txt_content = findViewById(R.id.txt_D_det_content);
        img_news=findViewById(R.id.img_Dnews);


        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");


        txt_title.setText(headlines.getTitle());
      txt_author.setText(headlines.getAuthor());
      txt_time.setText(headlines.getPublishedAt());
      txt_detail.setText(headlines.getDescription());
      txt_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);

    }
}