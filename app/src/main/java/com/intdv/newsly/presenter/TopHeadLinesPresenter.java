package com.intdv.newsly.presenter;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.intdv.newsly.model.ResponseModel;
import com.intdv.newsly.view.TopHeadlinesView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TopHeadLinesPresenter extends BasePresenter {

    private static final String TAG = TopHeadLinesPresenter.class.getSimpleName();
    private TopHeadlinesView headlinesView;

    public TopHeadLinesPresenter(TopHeadlinesView headlinesView, Context context) {
        super(context);
        this.headlinesView = headlinesView;
    }

    public void getTopHeadlines(){
        AndroidNetworking.get("https://newsapi.org/v2/top-headlines?country=us&apiKey=")
                .addQueryParameter("sources", "ars-technica")
                .addQueryParameter("apiKey", APP_TOKEN)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        returnNewsArticles(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e(TAG, "onError: " + anError.getErrorDetail() );
                    }
                });
    }

    private void returnNewsArticles(String response) {
        ResponseModel responseModel = new Gson().fromJson(response, ResponseModel.class);
        headlinesView.onHeadlinesReceived(responseModel.getNewsArticles());
    }
}
