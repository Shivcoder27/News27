package com.example.news27;

import com.example.news27.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchFata(List<NewsHeadlines> list, String message);
    void onError(String message);
}
