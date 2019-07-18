package com.intdv.newsly.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.intdv.newsly.R;
import com.intdv.newsly.adapters.TopHeadlinesAdapter;
import com.intdv.newsly.model.NewsArticle;
import com.intdv.newsly.presenter.TopHeadLinesPresenter;
import com.intdv.newsly.view.TopHeadlinesView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopHeadlinesFragment extends Fragment implements TopHeadlinesView {


    @BindView(R.id.topHeadlinesRV)
    RecyclerView topHeadlinesRV;

    public TopHeadlinesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_headlines, container, false);
        ButterKnife.bind(this, view);
        getArticles();
        setupRecyclerView();
        return view;
    }

    private void getArticles() {
        TopHeadLinesPresenter topHeadLinesPresenter = new TopHeadLinesPresenter(this, getContext());
        topHeadLinesPresenter.getTopHeadlines();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        topHeadlinesRV.setLayoutManager(layoutManager);
    }

    @Override
    public void onHeadlinesReceived(List<NewsArticle> newsArticles) {
        TopHeadlinesAdapter topHeadlinesAdapter = new TopHeadlinesAdapter(getContext(), newsArticles);
        topHeadlinesRV.setAdapter(topHeadlinesAdapter);
    }
}
