package com.codingwithtashi.mvvmfirebaseapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.FirebaseFirestore;
import com.codingwithtashi.mvvmfirebaseapp.models.Blog;
import com.codingwithtashi.mvvmfirebaseapp.repository.BlogRepository;

import java.util.List;

public class ListViewModel extends ViewModel {
    MutableLiveData<List<Blog>> blogListMutableLiveData;
    FirebaseFirestore mFirestore;
    BlogRepository blogRepository;

    public ListViewModel() {
        blogRepository = new BlogRepository();
        blogListMutableLiveData=  blogRepository.getBlogListMutableLiveData();
        mFirestore = FirebaseFirestore.getInstance();
    }

    public MutableLiveData<List<Blog>> getLiveBlogData() {
        return blogListMutableLiveData;
    }
}
