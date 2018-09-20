package com.example.hp.rxjava_reycleview;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public  class RetrofitClinet {
    private static  Retrofit ourInstance ;


    public  static Retrofit getInstance() {
        if(ourInstance==null){

            ourInstance=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

        }
        return ourInstance;
    }

    private RetrofitClinet() {
    }
}
