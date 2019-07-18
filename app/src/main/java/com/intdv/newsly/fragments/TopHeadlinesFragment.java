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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopHeadlinesFragment extends Fragment {


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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        topHeadlinesRV.setLayoutManager(layoutManager);
        List<NewsArticle> articles = new ArrayList<>();
        articles.add(new NewsArticle());
        topHeadlinesRV.setAdapter(new TopHeadlinesAdapter(getContext(), articles));
        return view;
    }
}
