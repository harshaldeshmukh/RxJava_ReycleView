package com.example.hp.rxjava_reycleview.Retrofit;



import com.example.hp.rxjava_reycleview.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetroInterface {
   @GET("posts")
   Observable<List<Post>> getPost();
}
