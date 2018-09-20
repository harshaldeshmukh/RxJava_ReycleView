  package com.example.hp.rxjava_reycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hp.rxjava_reycleview.Adapter.RecycleViewAdapter;
import com.example.hp.rxjava_reycleview.Retrofit.RetroInterface;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

  public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
      RetroInterface anInterface;
      CompositeDisposable compositeDisposable = new CompositeDisposable();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit =RetrofitClinet.getInstance();
        anInterface = retrofit.create(RetroInterface.class);

        recyclerView = (RecyclerView)findViewById(R.id.recyecleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ftechData();



    }

      private void ftechData() {
        compositeDisposable.add(anInterface.getPost().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Post>>() {
            @Override
            public void accept(List<Post> posts) throws Exception {
            displayData(posts);
            }
        }));
      }

      private void displayData(List<Post> posts) {
          RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(MainActivity.this,posts);

          recyclerView.setAdapter(recycleViewAdapter);
      }

      @Override
      protected void onStop() {
        compositeDisposable.clear();
          super.onStop();
      }
  }
