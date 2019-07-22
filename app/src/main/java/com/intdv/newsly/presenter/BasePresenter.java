package com.intdv.newsly.presenter;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;

public abstract class BasePresenter {

    protected static final String APP_TOKEN  = "bd25d8ed9612481a93da6f19d8dfec9d";

    protected BasePresenter(Context context) {
        // TODO: this initialization should be move to app OnCreate Method
        AndroidNetworking.initialize(context.getApplicationContext());
    }
}
