package com.codingwithtashi.mvvmfirebaseapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codingwithtashi.mvvmfirebaseapp.R;
import com.codingwithtashi.mvvmfirebaseapp.models.Blog;

import java.util.List;

/**
 * Created by kunchok on 19/02/2021
 */
public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {
    List<Blog> blogList;
    public BlogAdapter(List<Blog> blogList){
        this.blogList = blogList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_blog_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(blogList.get(position).getTitle());
        holder.description.setText(blogList.get(position).getDescription());
        Glide.with(holder.itemView.getContext()).load(blogList.get(position).getImageUrl()).into(holder.blogImage);

    }
    @Override
    public int getItemCount() {
        if(blogList!=null){
            return blogList.size();
        }else
            return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView title;
        TextView description;
        ImageView blogImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            title = view.findViewById(R.id.title);
            description = view.findViewById(R.id.description);
            blogImage = view.findViewById(R.id.image);
        }
    }
}
