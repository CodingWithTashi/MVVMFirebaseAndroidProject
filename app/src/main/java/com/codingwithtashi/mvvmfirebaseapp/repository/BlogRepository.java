package com.codingwithtashi.mvvmfirebaseapp.repository;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.codingwithtashi.mvvmfirebaseapp.models.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunchok on 19/02/2021
 */
public class BlogRepository {
    MutableLiveData<List<Blog>> blogListMutableLiveData;
    FirebaseFirestore mFirestore;
    MutableLiveData<Blog> blogMutableLiveData;

    public BlogRepository() {
        this.blogListMutableLiveData = new MutableLiveData<>();
        //define firestore
        mFirestore = FirebaseFirestore.getInstance();
        //define bloglist
        blogMutableLiveData = new MutableLiveData<>();

    }
    //get blog from firebase firestore
    public MutableLiveData<List<Blog>> getBlogListMutableLiveData() {
        Log.i("TAG", "getBlogListMutableLiveData: ");
        mFirestore.collection("Blog").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                List<Blog> blogList = new ArrayList<>();
                for (QueryDocumentSnapshot doc : value) {
                    if (doc != null) {
                        blogList.add(doc.toObject(Blog.class));
                    }
                }
                blogListMutableLiveData.postValue(blogList);
            }
        });
        return blogListMutableLiveData;
    }

    //delete blog

    //update blog
}
