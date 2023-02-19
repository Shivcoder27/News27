package com.example.news27;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.news27.Models.NewsApiResponse;
import com.example.news27.Models.NewsHeadlines;
import com.example.news27.Models.RequestManager;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener{
RecyclerView recyclerView;
CustomAdapter adapter;
ProgressDialog progressDialog;

SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      searchView = findViewById(R.id.search_view);
      searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
          @Override
          public boolean onQueryTextSubmit(String query) {
              progressDialog.setTitle("fetching news of "+query);
              progressDialog.show();
              RequestManager requestManager = new RequestManager(MainActivity.this);
              requestManager.getNewsHeadlines(listener,"general", query);
              return true;
          }

          @Override
          public boolean onQueryTextChange(String newText) {
              return false;
          }
      });



        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Fetching Latest News...");
        progressDialog.show();

        RequestManager requestManager = new RequestManager(MainActivity.this);
        requestManager.getNewsHeadlines(listener,"general", null);
        recyclerView = findViewById(R.id.recycler_main);


    }
    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchFata(List<NewsHeadlines> list, String message) {
           if(list.isEmpty()){
               Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
           }
            else {
               showNews(list);
               progressDialog.dismiss();
           }
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "An Error Occured from server", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(MainActivity.this,list,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {
    startActivity(new Intent(this,NewsDetails.class).putExtra("data",headlines));
    }
}