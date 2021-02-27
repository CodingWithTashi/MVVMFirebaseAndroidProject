package com.codingwithtashi.mvvmfirebaseapp.models;

/**
 * Created by kunchok on 19/02/2021
 */
public class Blog {
    String title;
    String description;
    String imageUrl;

    public Blog() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
