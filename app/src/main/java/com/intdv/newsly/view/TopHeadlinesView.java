package com.intdv.newsly.view;

import com.intdv.newsly.model.NewsArticle;

import java.util.List;

public interface TopHeadlinesView {
    void onHeadlinesReceived(List<NewsArticle> newsArticles);
}
