package com.intdv.newsly.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.intdv.newsly.R;
import com.intdv.newsly.adapters.TopHeadlinesAdapter;
import com.intdv.newsly.model.NewsArticle;
import com.intdv.newsly.presenter.TopHeadLinesPresenter;
import com.intdv.newsly.view.TopHeadlinesView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopHeadlinesFragment extends Fragment implements TopHeadlinesView, TopHeadlinesAdapter.DataUpdatedListener {


    @BindView(R.id.topHeadlinesRV)
    RecyclerView topHeadlinesRV;
    @BindView(R.id.topHeadlinesSwipeLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private TopHeadlinesAdapter topHeadlinesAdapter;
    private TopHeadLinesPresenter headLinesPresenter;


    public TopHeadlinesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_headlines, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        setupSwipeToRefreshLayout();
        getArticles();
        return view;
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        topHeadlinesRV.setLayoutManager(layoutManager);
    }

    private void setupSwipeToRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(this::refreshNewsArticles);
    }

    private void refreshNewsArticles() {
        getArticles();
    }

    private void getArticles() {
        if (headLinesPresenter == null)
            headLinesPresenter = new TopHeadLinesPresenter(this, getContext());
        headLinesPresenter.getTopHeadlines();
    }


    @Override
    public void onHeadlinesReceived(List<NewsArticle> newsArticles) {
        updateHeadlinesAdapter(newsArticles);
        topHeadlinesRV.setAdapter(topHeadlinesAdapter);
    }

    private void updateHeadlinesAdapter(List<NewsArticle> newsArticles) {
        if (topHeadlinesAdapter == null)
            topHeadlinesAdapter = new TopHeadlinesAdapter(getContext(), newsArticles);
        else topHeadlinesAdapter.updateHeadlines(newsArticles, this);
    }

    @Override
    public void onDataUpdated() {
        Toast.makeText(getContext(), R.string.news_updated, Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
    }
}
