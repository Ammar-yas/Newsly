package com.intdv.newsly.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.intdv.newsly.R;
import com.intdv.newsly.fragments.TopHeadlinesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTopHeadlines();
    }

    private void showTopHeadlines() {
        TopHeadlinesFragment topHeadlinesFragment = new TopHeadlinesFragment();
        replaceMainFrameLayout(topHeadlinesFragment);
    }

    private void replaceMainFrameLayout(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainActivityFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}
