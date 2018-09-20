package com.example.hp.rxjava_reycleview.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.rxjava_reycleview.Post;
import com.example.hp.rxjava_reycleview.R;


import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
  private    Context context;

    private  List<Post> posts;

    public RecycleViewAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(posts.get(position).body);
        holder.textView1.setText(posts.get(position).title);


    }



    @Override
    public int getItemCount() {
        return posts.size();
    }

    public  class  ViewHolder  extends  RecyclerView.ViewHolder{
            TextView textView,textView1;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textView);
            textView1=(TextView)itemView.findViewById(R.id.textView1);

        }
    }
}
