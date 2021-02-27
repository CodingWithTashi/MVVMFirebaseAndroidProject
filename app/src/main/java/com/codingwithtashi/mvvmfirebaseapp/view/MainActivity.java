package com.codingwithtashi.mvvmfirebaseapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.codingwithtashi.mvvmfirebaseapp.R;
import com.codingwithtashi.mvvmfirebaseapp.adapter.BlogAdapter;
import com.codingwithtashi.mvvmfirebaseapp.viewmodel.ListViewModel;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private ListViewModel listViewModel;
    private RecyclerView blogRecycler;
    private BlogAdapter blogAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("MVVM Example");
        //define viewmodel
        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);
        progressDialog =new ProgressDialog(this);
        progressDialog.setTitle("Loading ...");
        progressDialog.show();

        blogRecycler = findViewById(R.id.container);
        blogRecycler.setLayoutManager(new LinearLayoutManager(this));
        blogRecycler.setHasFixedSize(true);
        // get blog through viewModel
        listViewModel.getLiveBlogData().observe(this, blogList -> {
            progressDialog.dismiss();
            blogAdapter = new BlogAdapter(blogList);
            blogRecycler.setAdapter(blogAdapter);
            blogAdapter.notifyDataSetChanged();
        });
    }
}